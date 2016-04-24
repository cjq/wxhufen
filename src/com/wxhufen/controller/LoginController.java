package com.wxhufen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wxhufen.mapper.UserMapper;
import com.wxhufen.po.User;
import com.wxhufen.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		return "/WEB-INF/jsp/login.jsp";
	}
	
	@RequestMapping(value="/loginSubmit",method={RequestMethod.POST})
	public String loginSubmit(User user,Model model,HttpServletRequest httpServletRequest){
		
		User baseUser = userService.selectUserByEmail(user.getEmail());
		HashMap<String, String> errors = new HashMap<String,String>();
		/**
		 * 进行登录校验
		 */
		if(baseUser==null){
			errors.put("email", "邮箱未注册");
		}
		if(baseUser==null || !user.getPassword().equals(baseUser.getPassword())){
			errors.put("password", "密码错误");
		}
		//数据回显和错误提醒
		if(!errors.isEmpty()){
			model.addAttribute("errors",errors);
			model.addAttribute("user", user); 
			return "/WEB-INF/jsp/login.jsp";
		}
		//登录成功设置session
		httpServletRequest.getSession().setAttribute("user", baseUser);
		return "redirect:/mp";
	}
}
