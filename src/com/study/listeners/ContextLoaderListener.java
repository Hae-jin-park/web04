package com.study.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.study.context.ApplicationContext;

//db 처리
@WebListener
public class ContextLoaderListener implements ServletContextListener {
	private static ApplicationContext actx;

	public static ApplicationContext getApplicationContext() {
		return actx;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	//	ServletContextListener.super.contextInitialized(sce);
		try {
			ServletContext sc = sce.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("ctxConfigLocation"));
			actx = new ApplicationContext(propertiesPath);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextDestroyed(sce);
		
	}
}
