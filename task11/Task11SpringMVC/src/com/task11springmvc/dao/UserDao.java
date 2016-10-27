package com.task11springmvc.dao;

import com.task11springmvc.pojo.User;
/**
 * DAO层，用于数据
 * @author Songbin
 *
 */
public class UserDao {
	public User get()
	{
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		return user;
	}
}
