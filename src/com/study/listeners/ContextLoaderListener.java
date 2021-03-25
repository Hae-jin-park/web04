package com.study.listeners;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
			actx = new ApplicationContext();
			
			String res = "com/study/dao/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
			actx.addBean("sqlSessionFactory", sqlSessionFactory);
			ServletContext sc = sce.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("ctxConfigLocation"));
			
			actx.prepareObjectsByProps(propertiesPath);
			
			actx.prepareObjectsByAnnotation("");
			
			actx.injectDependency();
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
