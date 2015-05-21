package org.jee.ssm.cms.service;

import java.util.List;

import org.jee.ssm.cms.model.User;

public interface UserService {

	public  List<User> getAllUsers();
	public  User getUserByUsername(String username);
	public  void addUser(User user);
	public  List<User> getUsersByPage(int pageSize, int currentPage ) ;
}
