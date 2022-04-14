package me.kickscar.mysite.web.mvc.guestbook;

import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if("add".equals(actionName)) {
			action = new AddAction();
		} else {
			action = new ListAction();
		}
		
		return action;
	}
}
