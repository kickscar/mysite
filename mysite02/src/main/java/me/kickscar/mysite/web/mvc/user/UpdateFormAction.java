package me.kickscar.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.kickscar.mysite.vo.UserVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 접근제어(인증이 필요한 접근에 대한 체크) 
		HttpSession session = request.getSession();
		if(session == null) {
			MvcUtils.redirect(request.getContextPath(), request, response);
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			MvcUtils.redirect(request.getContextPath(), request, response);
			return;
		}
		
		Long userNo = authUser.getNo();
		// UserVo userVo = new UserRepository().findByNo(userNo);
		// request.setAttribute("userVo", userVo);
		MvcUtils.forward("user/updateform", request, response);
	}

}
