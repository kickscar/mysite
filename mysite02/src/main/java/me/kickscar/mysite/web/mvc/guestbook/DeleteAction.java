package me.kickscar.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.mysite.repository.GuestbookRepository;
import me.kickscar.mysite.vo.GuestbookVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class DeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		
		new GuestbookRepository().delete(vo);
		MvcUtils.redirect(request.getContextPath() + "/guestbook", request, response);
	}
}
