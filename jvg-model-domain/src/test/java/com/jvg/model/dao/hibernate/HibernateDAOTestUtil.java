package com.jvg.model.dao.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateDAOTestUtil {

	/**
	 * Private constructor to prevent instantiation
	 */
	private HibernateDAOTestUtil() {
	}

	/**
	 * Gets a new instance of the ApplicationContext for the test
	 * 
	 * @return the appCtx
	 */
	public static ApplicationContext setUpTest() {
		String[] configLocs = { "classpath:/appCtx/**/datasource.xml",
				"classpath:/appCtx/**/hibernate.xml",
				"classpath:/appCtx/**/dataSetBeans.xml" };
		return new ClassPathXmlApplicationContext(configLocs);
	}

}
