package me.kickscar.mysite.web.mvc.board;

import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("view".equals(actionName)) {
			action = new ViewAction();
		} else { // default Action
			action = new ListAction();
		}
		
		return action;
	}
}