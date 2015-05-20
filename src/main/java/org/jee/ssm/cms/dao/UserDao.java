package org.jee.ssm.cms.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.jee.ssm.cms.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
	
	public  User getUserByUsername(@Param("username") String username);
	public  void addUser(User user);

}
