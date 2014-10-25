package com.jvg.model.dao.hibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * 
 * 
 * @author Jon Vandergriff
 */
public class BaseDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.googlecode.genericdao.dao.hibernate.HibernateBaseDAO#setSessionFactory
	 * (org.hibernate.SessionFactory)
	 */
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}