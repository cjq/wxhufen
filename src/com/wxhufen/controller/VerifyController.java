package com.wxhufen.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thoughtworks.xstream.XStream;
import com.wxhufen.mapper.FollowerMapper;
import com.wxhufen.po.Follower;
import com.wxhufen.po.MP;
import com.wxhufen.po.Message;
import com.wxhufen.service.FollowerService;
import com.wxhufen.service.MPService;
import com.wxhufen.service.UserService;


@Controller
public class VerifyController {
	
	@Autowired
	private MPService mpService;
	@Autowired
	private UserService userService;
	@Autowired
	private FollowerService followerService;
	
	@RequestMapping("/verify")
	public void verify(String signature,String timestamp,String nonce,String echostr,HttpServletResponse httpServletResponse,
			HttpServletRequest httpServletRequest) throws IOException, DocumentException{
		httpServletResponse.setCharacterEncoding("UTF-8");
//		// 将token、timestamp、nonce三个参数进行字典序排序
		Object[] object = soft("wxhufen",timestamp,nonce);
		String str  = object[0].toString() + object[1].toString() + object[2].toString();
		String shastr = SHA1(str);
		if(shastr.equals(signature)){
			System.out.println("验证成功");
			
			try {
				//与微信握手 如果有异常代表已经是用户发送的信息
				httpServletResponse.getWriter().write(echostr); 
			} catch (Exception e) {
				try {
		        	SAXReader reader = new SAXReader();
		        	Document document = reader.read(httpServletRequest.getInputStream());
		        	Element root = document.getRootElement();
			        List<String> elestr = new ArrayList<String>();
			        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
			        	Element element = (Element) i.next();
			        	elestr.add(element.getText());
			        }
			        
			        String mpid = elestr.get(0);
			        String openid = elestr.get(1);
			        String time = elestr.get(2);
			        String context = elestr.get(4);
			        Integer userid = Integer.parseInt(context);
			        //判断是否数据库是否有 否则 将 MPid 添加到数据库
			        if(mpService.isExistByMPid(mpid)){
			        	// 如果找到微信原始id ，进行发布任务判断和判断用户是否存在
			        	if (mpService.isExistByMPname(mpid) && userService.isExistByUserid(userid)) {
			        		//判断是否已经粉过	
			        		if(!followerService.isExistByOpenid(openid)){
			        				//1.扣除任务次数
					        		mpService.updateMPTotalCountByMPId(mpid);
					        		MP mp = mpService.selectMPByMPid(mpid);
					        		//2.添加用户积分
					        		userService.updatePointByUserId(userid, mp.getTaskpoint());
					        		//3.添加粉丝到表
					        		Follower follower = new Follower();
					        		follower.setMpid(mpid);
					        		follower.setUserid(userid);
					        		follower.setOpenid(openid);
					        		followerService.insertFollower(follower);
					        		//4.回复成功消息
					        		Message message = new Message();
					        		message.setToUserName("<![CDATA["+openid+"]]>");
					        		message.setFromUserName("<![CDATA["+mpid+"]]>");
					        		message.setCreateTime((new Date().getTime()));
					        		message.setMsgType("<![CDATA[text]]>");
					        		message.setContent("<![CDATA[用户名:"+userService.selectUsernameByUserid(userid)+" 关注成功已获取相应积分"+"]]>");
					        		httpServletResponse.getWriter().write(toXML(message));
			        			}else{
			        				System.out.println("已经粉过");
			        				Message message = new Message();
					        		message.setToUserName("<![CDATA["+openid+"]]>");
					        		message.setFromUserName("<![CDATA["+mpid+"]]>");
					        		message.setCreateTime((new Date().getTime()));
					        		message.setMsgType("<![CDATA[text]]>");
					        		message.setContent("<![CDATA[用户名:"+userService.selectUsernameByUserid(userid)+" 已经粉过"+"]]>");
					        		httpServletResponse.getWriter().write(toXML(message));
			        			} 
						}else{
							System.out.println("公众号已添加到数据库中但未发布任务或者未找到用户id");
							
							//响应给微信禁止重新发起请求
			        		httpServletResponse.getWriter().write("success");
						}
			        }else{
			        	 //如果没找到添加进数据库
			        	mpService.insertMPid(mpid);
			        	
			        	//响应给微信禁止重新发起请求
		        		httpServletResponse.getWriter().write("success");
			        }
				} catch (Exception e1) {
					System.out.println("错误"+ e1.getMessage());
				}
			}
		
		}else{
			System.out.println("验证失败");
		}
		
	}
	
	 
	
	
	// 将token、timestamp、nonce三个参数进行字典序排序
	public static Object[] soft(String token,String timestamp,String nonce){
		List<String> list = new ArrayList<String>();
		list.add(token);
		list.add(timestamp);
		list.add(nonce);
		Object[] object = list.toArray();
		Arrays.sort(object);
		return object;
	}
	
	public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
	public String toXML(Message message) throws UnsupportedEncodingException{
		XStream xstream = new XStream();
		xstream.alias("xml", Message.class);
		String xmlStr = xstream.toXML(message).replace("&lt;", '<' + "").replace("&gt;", '>' + "");
		return xmlStr;
	}
}
