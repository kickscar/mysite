package me.kickscar.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.kickscar.mysite.repository.UserRepository;
import me.kickscar.mysite.vo.UserVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo userVo = new UserRepository().findByEmailAndPassword(email, password);
		if(userVo == null) {
			request.setAttribute("result", "fail");
			request.setAttribute("email", email);
			MvcUtils.forward("user/loginform", request, response);
			return;
		}
		
		/* 인증처리(session 처리) */
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
		// main으로 리다이렉트!
		MvcUtils.redirect(request.getContextPath(), request, response);
	}

}
