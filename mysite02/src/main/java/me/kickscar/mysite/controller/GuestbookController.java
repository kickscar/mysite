package me.kickscar.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.mysite.web.mvc.guestbook.GuestbookActionFactory;
import me.kickscar.web.mvc.Action;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// EncodingFilter 대체
		// request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("a");

		Action action = new GuestbookActionFactory().getAction(actionName);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
