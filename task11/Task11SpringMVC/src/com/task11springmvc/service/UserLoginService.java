package com.task11springmvc.service;

import com.task11springmvc.dao.UserDao;
import com.task11springmvc.pojo.User;
/**
 * 业务层，实现对登录信息的判断。
 * @author Songbin
 *
 */
public class UserLoginService {
	 private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	 
	public Boolean validatedLogin(User user)
	{
		User u = userDao.get();
		if (!u.getUsername().equals(user.getUsername()) || !u.getPassword().equals(user.getPassword())) {
			return false;
		}
		
		return true;
	}
}
