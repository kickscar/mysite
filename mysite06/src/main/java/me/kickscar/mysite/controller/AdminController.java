package me.kickscar.mysite.controller;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.kickscar.mysite.exception.FileUploadException;
import me.kickscar.mysite.security.Auth;
import me.kickscar.mysite.service.FileUploadService;
import me.kickscar.mysite.service.SiteService;
import me.kickscar.mysite.vo.SiteVo;

@Auth(role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Log LOGGER = LogFactory.getLog(AdminController.class);

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private SiteService siteService;

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("")
	public String main(Model model) {
		SiteVo site = siteService.getSite();
		model.addAttribute("site", site);
		return "admin/main";
	}
	
	@RequestMapping("/main/update")
	public String main(SiteVo site, @RequestParam("file") MultipartFile file) {
		try {
			String profile = fileUploadService.restoreImage(file);
			site.setProfile(profile);
		} catch(FileUploadException ex) {
			LOGGER.info("Admin Main Update:" + ex);
		}
		
		siteService.update(site);
		servletContext.setAttribute("site", site);
		
		return "redirect:/admin";
	}	
	
	@RequestMapping("/guestbook")
	public String guestbook() {
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
