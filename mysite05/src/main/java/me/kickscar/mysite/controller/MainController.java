package me.kickscar.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.kickscar.mysite.service.SiteService;
import me.kickscar.mysite.vo.SiteVo;
import me.kickscar.mysite.vo.UserVo;

@Controller
public class MainController {
	@Autowired
	private SiteService siteService;
	
	@RequestMapping("/")
	public String index(Model model) {
		SiteVo vo = siteService.getSite();
		model.addAttribute("site", vo);
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/msg1")
	public String message1() {
		return "안녕~~";
	}
	
	@ResponseBody
	@RequestMapping("/msg2")
	public Object message2() {
		UserVo vo = new UserVo();
		vo.setNo(1L);
		vo.setEmail("kickscar@gmail.com");
		vo.setName("안대혁");
		
		return vo;
	}
	
}
