package me.kickscar.mysite.controller;

import me.kickscar.mysite.service.FileUploadService;
import me.kickscar.mysite.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.kickscar.mysite.security.Auth;
import me.kickscar.mysite.vo.SiteVo;

import javax.servlet.ServletContext;

@Auth(role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private SiteService siteService;

	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("")
	public String main(Model model) {
		SiteVo vo = siteService.getSite();
		model.addAttribute("vo", vo);
		return "admin/main";
	}

	@RequestMapping(value="/main/update", method=RequestMethod.POST)
	public String updateMain(SiteVo site, @RequestParam("file") MultipartFile file) {
		String profile = fileUploadService.restore(file);

		if(profile != null) {
			site.setProfile(profile);
		}

		siteService.updateSite(site);

		servletContext.setAttribute("site", site);
		return "redirect:/admin";
	}
	
	@RequestMapping("/guestbook")
	public String guesbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}

	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
}
