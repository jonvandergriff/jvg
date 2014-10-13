package com.stride.cartrek.model.dao.hibernate;

import java.io.Serializable;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface IRepository<T, ID extends Serializable> extends
		GenericDAO<T, ID> {

}
