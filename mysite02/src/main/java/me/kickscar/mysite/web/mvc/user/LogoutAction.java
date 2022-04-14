package me.kickscar.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			/* 로그아웃 */
			session.removeAttribute("authUser");
			session.invalidate();
		}
		
		MvcUtils.redirect(request.getContextPath(), request, response);
	}

}
