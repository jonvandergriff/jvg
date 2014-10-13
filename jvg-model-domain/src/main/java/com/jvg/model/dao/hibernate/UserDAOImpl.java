package com.stride.cartrek.model.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stride.cartrek.model.dto.User;

@Repository
@Transactional
public class UserDAOImpl extends BaseDAO<User, Long> implements UserDAO {

}
