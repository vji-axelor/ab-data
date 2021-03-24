package com.ab.data.guice;

import com.ab.data.service.ContectDao;
import com.ab.data.service.ContectService;
import com.ab.data.serviceimp.ContectDaoImp;
import com.ab.data.serviceimp.ContectServiceImp;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceServletConfigure extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new ServletModule() {
			
			@Override
			protected void configureServlets() {
				bind(ContectDao.class).to(ContectDaoImp.class);
				bind(ContectService.class).to(ContectServiceImp.class);
			}
			
		});
	}
								

}
