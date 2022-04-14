package me.kickscar.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.kickscar.mysite.repository.UserRepository;
import me.kickscar.mysite.vo.UserVo;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.MvcUtils;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		new UserRepository().insert(vo);
		MvcUtils.redirect(request.getContextPath() + "/user?a=joinsuccess", request, response);
	}

}
