package com.wxhufen.controller;

import com.wxhufen.po.MP;
import com.wxhufen.po.User;
import com.wxhufen.service.MPService;
import com.wxhufen.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/task"})
public class TaskController
{
  @Autowired
  private MPService mpService;
  @Autowired
  private UserService userService;
  
  @RequestMapping({"/add"})
  public String task()
  {
    return "/WEB-INF/jsp/task.jsp";
  }
  
  @RequestMapping(value={"/verify"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String verify(MP mp, Model model, HttpSession httpSession, MultipartFile imagefile, HttpServletRequest httpServletRequest)
    throws IllegalStateException, IOException
  {
    Map<String, String> map = new HashMap();
    if (imagefile != null)
    {
      String filename = imagefile.getOriginalFilename();
      if (filename.lastIndexOf(".jpg") < 0) {
        map.put("imagefile", "必须为jpg格式的微信二维码图片");
      }
    }
    if ((mp.getMpname() == null) || (mp.getMpname().equals("")) || (mp.getMpname().length() > 10)) {
      map.put("mpname", "长度错误");
    }
    if ((mp.getMpid() == null) || (mp.getMpid().equals("")) || (!this.mpService.isExistByMPid(mp.getMpid())))
    {
      map.put("mpid", "未找到你的原始id,请按要求配置");
    }
    else
    {
      MP baseMP = this.mpService.selectMPByMPid(mp.getMpid());
      if (Integer.parseInt(baseMP.getTotalcount()) > 0) {
        map.put("mpid", "此原始ID任务进行中,请任务结束后在操作");
      }
    }
    if ((mp.getTaskpoint() == null) || (!isInteger(mp.getTaskpoint())) || (Integer.parseInt(mp.getTaskpoint()) < 5))
    {
      map.put("mptaskpoint", "不能为空或者不能为字符或者积分小于5");
    }
    else
    {
      User user = (User)httpSession.getAttribute("user");
      Integer taskpoint = Integer.valueOf(Integer.parseInt(mp.getTaskpoint()));
      if (user.getPoint().intValue() < taskpoint.intValue()) {
        map.put("mptaskpoint", "任务积分大于现有的积分");
      }
    }
    if ((mp.getTotalcount() == null) || (!isInteger(mp.getTotalcount())) || (Integer.parseInt(mp.getTotalcount()) < 1))
    {
      map.put("totalcount", "不能为空或者不能为字符或次数小于1");
    }
    else
    {
      User user = (User)httpSession.getAttribute("user");
      Integer userpoint = user.getPoint();
      String taskpoint = mp.getTaskpoint();
      String totalcount = mp.getTotalcount();
      Integer totalpoint = Integer.valueOf(Integer.parseInt(taskpoint) * Integer.parseInt(totalcount));
      if (userpoint.intValue() < totalpoint.intValue()) {
        map.put("totalcount", "积分不足");
      }
    }
    if (!map.isEmpty())
    {
      model.addAttribute("errors", map);
      model.addAttribute("mp", mp);
      return "/WEB-INF/jsp/task.jsp";
    }
    String newfilename = UUID.randomUUID().toString() + imagefile.getOriginalFilename().substring(imagefile.getOriginalFilename().lastIndexOf("."));
    
    File path = new File("/data/imagefile/" + newfilename);
    imagefile.transferTo(path);
    

    mp.setQrcode(newfilename);
    mp.setTime(new Date());
    User user = (User)httpSession.getAttribute("user");
    mp.setUserid(user.getUserid());
    

    String taskpoint = mp.getTaskpoint();
    String totalcount = mp.getTotalcount();
    Integer totalpoint = Integer.valueOf(Integer.parseInt(totalcount) * Integer.parseInt(taskpoint));
    this.userService.updatePoint(user.getUserid(), totalpoint);
    

    this.mpService.updatePM(mp);
    

    Integer point = this.userService.getUserPoint(user.getEmail());
    user.setPoint(point);
    
    return "redirect:/mp";
  }
  
  public static boolean isInteger(String value)
  {
    try
    {
      Integer.parseInt(value);
      return true;
    }
    catch (NumberFormatException e) {}
    return false;
  }
}
