package me.kickscar.mysite.web.mvc.user;

import me.kickscar.mysite.web.mvc.main.MainAction;
import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();
		} else if("loginform".equals(actionName)) {
			action = new LoginFormAction();
		} else if("join".equals(actionName)) {
			action = new JoinAction();
		} else if("login".equals(actionName)) {
			action = new LoginAction();
		} else if("logout".equals(actionName)) {
			action = new LogoutAction();
		} else if("updateform".equals(actionName)) {
			action = new UpdateFormAction();
		} else {
			action = new MainAction();
		}
		
		return action;
	}

}
