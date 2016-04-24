package com.wxhufen.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wxhufen.po.Follower;
import com.wxhufen.po.MP;
import com.wxhufen.po.Page;
import com.wxhufen.service.FollowerService;
import com.wxhufen.service.MPService;


@Controller
public class MPController {
	@Autowired
	private MPService mpService;
	@Autowired
	private FollowerService followerService;
	
	@RequestMapping("/mp")
	public String mp(Model model,@RequestParam(defaultValue="1",value="pagecode") int pagecode,HttpServletRequest httpServletRequest) throws Exception{
		/*
		 *查询所有发过任务的公众号
		 */
		Page page = new Page();
		page.setPageCode(pagecode);
		page.setItemCount(9);
		page.setTotalitems(mpService.getMPCount());
		page.setHead();
		List<MP> list = mpService.selectAllMPItems(page);
		//粉丝数据补全
		for (MP mp : list) {
			int fnumber = followerService.selectFollowerNumber(mp.getMpid());
			mp.setFnumber(fnumber);
		}
		page.setList(list);

		model.addAttribute("page", page);
		
		return "/WEB-INF/jsp/mp.jsp";
	}
	
}
