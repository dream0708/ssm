package org.jee.ssm.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jee.ssm.cms.model.User;
import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Repository("userDao")
public interface UserDao {
	
	public  List<User> getAllUsers(PageBounds pageBounds);
	public  User getUserByUsername(@Param("username") String username);
	public  void addUser(User user);

}
