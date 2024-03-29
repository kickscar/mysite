package me.kickscar.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import me.kickscar.mysite.service.SiteService;
import me.kickscar.mysite.vo.SiteVo;

public class SiteInterceptor implements HandlerInterceptor {
	@Autowired
	private SiteService siteService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SiteVo site = (SiteVo)request.getServletContext().getAttribute("site");
		if(site == null) {
			site = siteService.getSite();
			request.getServletContext().setAttribute("site", site);
		}

		return true;
	}
}
