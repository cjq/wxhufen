package com.wxhufen.controller;

import com.wxhufen.po.CutomUser;
import com.wxhufen.po.User;
import com.wxhufen.service.UserService;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisController
{
  @Autowired
  private UserService userService;
  
  @RequestMapping({"/regis"})
  public String regis()
  {
    return "/WEB-INF/jsp/regis.jsp";
  }
  
  @RequestMapping(value={"/regisSubmit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String regisSubmit(CutomUser cutomUser, Model model)
  {
    HashMap<String, String> errors = new HashMap();
    String username = cutomUser.getUsername();
    if ((username == null) || (username.equals("")) || (username.length() > 10) || (username.length() < 3)) {
      errors.put("username", "用户名格式不正确");
    }
    if (this.userService.isExistByUserName(username)) {
      errors.put("username", "用户名已注册");
    }
    String password = cutomUser.getPassword();
    if ((password == null) || (password.equals("")) || (password.length() > 16) || (password.length() < 6)) {
      errors.put("password", "密码格式不正确");
    }
    String samePassword = cutomUser.getSamePassword();
    if ((samePassword == null) || (samePassword.equals("")) || (!samePassword.equals(password))) {
      errors.put("samePassword", "输入错误");
    }
    String email = cutomUser.getEmail();
    boolean pattern = Pattern.matches("[a-zA-Z]*[0-9]*@[a-z]+.[a-z]+", email);
    if ((email == null) || (email.equals("")) || (!pattern)) {
      errors.put("email", "邮箱格式错误");
    } else if (this.userService.isExistByEmail(email)) {
      errors.put("email", "邮箱已存在");
    }
    if (!errors.isEmpty())
    {
      model.addAttribute("errors", errors);
      return "/WEB-INF/jsp/regis.jsp";
    }
    User user = new User();
    BeanUtils.copyProperties(cutomUser, user);
    
    user.setPoint(Integer.valueOf(150));
    this.userService.insertUser(user);
    return "redirect:/mp";
  }
}
