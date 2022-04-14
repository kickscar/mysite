package me.kickscar.mysite.web.mvc.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MvcUtils.forward("main/index", request, response);
	}

}
