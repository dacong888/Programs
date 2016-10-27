package com.dbusers.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task07hibernate02.pojo.LoginUser;
import com.task07hibernate02.pojo.User;
import com.task07hibernate02.users.service.UsersService;

public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 5467243810376140877L;
	private HttpServletRequest request;
	UsersService usersService = new UsersService();
	LoginUser lu = new LoginUser();
	User user = new User();

	public LoginUser getLu() {
		return lu;
	}

	public void setLu(LoginUser lu) {
		this.lu = lu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// 实现各业务方法
	// 登录验证
	public String verify() {
		return usersService.verifyUser(request, lu);
	}

	// 注册信息
	public String add() {
		return usersService.registerUser(request, user);
	}

	// 删除用户
	public String delete() {
		return usersService.deleteUser(request, user);

	}

	// 查看用户信息
	public String get() {
		return usersService.getUser(request, user);
	}

	// 查看所有用户信息
	public String listAll() {
		return usersService.getAll(request);
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
