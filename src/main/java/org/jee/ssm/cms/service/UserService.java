package org.jee.ssm.cms.service;

import org.jee.ssm.cms.model.User;

public interface UserService {

	public  User getUserByUsername(String username);
	public  void addUser(User user);
}
