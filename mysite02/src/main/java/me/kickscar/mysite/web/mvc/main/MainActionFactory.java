package me.kickscar.mysite.web.mvc.main;

import me.kickscar.web.mvc.Action;
import me.kickscar.web.mvc.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		return new MainAction();
	}

}
