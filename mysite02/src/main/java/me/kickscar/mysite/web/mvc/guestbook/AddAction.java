package me.kickscar.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.mysite.repository.GuestbookRepository;
import me.kickscar.mysite.vo.GuestbookVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = request.getParameter("message");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		new GuestbookRepository().insert(vo);
		MvcUtils.redirect(request.getContextPath() + "/guestbook", request, response);
	}

}
