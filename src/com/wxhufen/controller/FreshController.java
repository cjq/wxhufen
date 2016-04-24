package com.wxhufen.controller;

import com.wxhufen.po.User;
import com.wxhufen.service.UserService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreshController
{
  @Autowired
  private UserService userService;
  
  @RequestMapping(value={"/fresh"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public void fresh(String username, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest)
    throws IOException
  {
    User user = (User)httpServletRequest.getSession().getAttribute("user");
    Integer point = this.userService.selectPointByUserName(username);
    
    user.setPoint(point);
    httpServletResponse.getWriter().println(this.userService.selectPointByUserName(username).toString());
  }
}
