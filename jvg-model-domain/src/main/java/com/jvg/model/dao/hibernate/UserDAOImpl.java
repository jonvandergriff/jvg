package com.jvg.model.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jvg.model.dto.User;

@Repository
@Transactional
public class UserDAOImpl extends BaseDAO<User, Long> implements UserDAO {

}
