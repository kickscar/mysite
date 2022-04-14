package me.kickscar.mysite.web.mvc.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.mysite.repository.GuestbookRepository;
import me.kickscar.mysite.vo.GuestbookVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class ListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestbookVo> list = new GuestbookRepository().findAll();
		
		request.setAttribute("list", list);
		MvcUtils.forward("guestbook/list", request, response);
	}
}
