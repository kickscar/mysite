package me.kickscar.mysite.initializer;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import me.kickscar.mysite.config.AppConfig;
import me.kickscar.mysite.config.WebConfig;

import static jakarta.servlet.ServletRegistration.*;

public class MysiteWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context's Configuration Class
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context's Configuration Class
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// Dispatcher Servlet Mapping URL
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		// Encoding Filter
		return new Filter[] { new CharacterEncodingFilter("UTF-8", false) };
	}

	@Override
	protected DispatcherServlet createDispatcherServlet(WebApplicationContext webApplicationContext) {
		// final DispatcherServlet dispatcherServlet = new DispatcherServlet(new GenericWebApplicationContext());
		// dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		// ServletRegistration.Dynamic servlet = webApplicationContext.getServletContext().addServlet("mvc", dispatcherServlet);
		// servlet.setMultipartConfig();
		// return dispatcherServlet;

		DispatcherServlet servlet = (DispatcherServlet)super.createDispatcherServlet(webApplicationContext);
		servlet.setThrowExceptionIfNoHandlerFound(true);
		return servlet;

	}
}