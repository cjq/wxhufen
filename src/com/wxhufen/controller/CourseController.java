package com.wxhufen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
	@RequestMapping("/course")
	public String course(){
		return "/WEB-INF/jsp/course.jsp";
	}
}
