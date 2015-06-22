package io.ray.websocket.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);

		
		DispatcherServlet dispatcher = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispather", dispatcher);

		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}

}
