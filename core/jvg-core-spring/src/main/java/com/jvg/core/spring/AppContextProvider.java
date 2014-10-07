package com.jvg.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This provides static access to the Spring {@link ApplicationContext}.
 * 
 * @author Jon Vandergriff
 * 
 */
@Component
public class AppContextProvider implements ApplicationContextAware {

	private static ApplicationContext ctx;

	/**
	 * Sets the {@link ApplicationContext}.
	 * 
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}

	/**
	 * Gets the {@link ApplicationContext}.
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

}
