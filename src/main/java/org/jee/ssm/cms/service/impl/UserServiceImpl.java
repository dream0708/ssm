package org.jee.ssm.cms.service.impl;

import javax.annotation.Resource;

import org.jee.ssm.cms.dao.UserDao;
import org.jee.ssm.cms.model.User;
import org.jee.ssm.cms.service.UserService;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService{

	

	private UserDao userDao;
	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}


	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
