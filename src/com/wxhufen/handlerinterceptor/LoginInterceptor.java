package com.wxhufen.handlerinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wxhufen.po.User;


public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		//没有登录的用户不能发布任务
		User user = (User) arg0.getSession().getAttribute("user");
		StringBuffer url = arg0.getRequestURL();
		if(url.indexOf("task")>0){
			if(user==null){
				arg0.getRequestDispatcher("/login").forward(arg0, arg1);
			}
		}
		
		return true;
	}

}
