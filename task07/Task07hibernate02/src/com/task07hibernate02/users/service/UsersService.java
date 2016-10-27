package com.task07hibernate02.users.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dbusers.util.DaoFactory;
import com.dbusers.util.SessionUtil;
import com.task07hibernate02.entity.Users;
import com.task07hibernate02.pojo.LoginUser;
import com.task07hibernate02.pojo.User;
import com.task07hibernate02.users.dao.UsersDao;

// 用户业务，对用户实体进行业务操作封装
public class UsersService {
	private UsersDao ud = DaoFactory.GetInstance("usersDao", UsersDao.class);

	// 验证用户登录
	public String verifyUser(HttpServletRequest request, LoginUser lu) {
		int i = totalCount();
		if (i == 0) {
			request.setAttribute("noUser", true);
			return "login";
		}

		// 列举出所有名字为lu.getUsername()的Users信息
		List<Users> list = get(lu.getUsername());
		// 如果为空,显示没有用户
		if (list.size() == 0) {
			request.setAttribute("noUser", true);
			return "login";
		}

		// 如果表中有对应的姓名，则进行密码比较
		for (Users us : list) {
			// 如果信息在list中，则跳转到
			if (us.getPassWord().equals(lu.getPassword())) {
				request.setAttribute("userInfo", list);
				return "info";
			} else {
				request.setAttribute("noUser", true);
				return "login";
			}
		}

		return "login";
	}

	// 用户注册信息
	public String registerUser(HttpServletRequest request, User user) {

		// 如果填写成功，将信息加入Users
		Users users = new Users();
		users.setUserName(user.getUserName());
		users.setPassWord(user.getPassWord());
		users.setRealName(user.getRealName());
		users.setAge(user.getAge().intValue());
		users.setPhoneNum(user.getPhoneNum());
		users.setAddress(user.getAddress());
		edit(users);
		request.setAttribute("userInfo", users);

		return "info";
	}

	// 删除用户信息
	public String deleteUser(HttpServletRequest request, User user) {
		delete(user.getId());
		List<Users> list = findAll();
		request.setAttribute("listAll", list);
		return "mgr";
	}
	
	// 获取用户信息
	public String getUser(HttpServletRequest request, User user){
		Users u = get(user.getId());
		request.setAttribute("userInfo", u);
		return "info";
	}
	
	// 获取所有用户信息
	public String getAll(HttpServletRequest request){
		List<Users> list = findAll();
		request.setAttribute("listAll", list);
		return "mgr";
	}

	private List<Users> findAll() {
		Transaction tx = null;
		List<Users> list = new ArrayList<>();
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			list = ud.findAll();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return list;
	}

	private void delete(int id) {
		Transaction tx = null;
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			ud.delete(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	private void edit(Users users) {
		Transaction tx = null;
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			ud.edit(users);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	private Users get(int id) {
		Transaction tx = null;
		Users users = null;
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			users = ud.get(id);
			// users.getAddress();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return users;
	}

	private List<Users> get(String field) {
		Transaction tx = null;
		List<Users> users = null;
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			users = ud.get(field);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

		return users;
	}

	public int totalCount() {
		int iCounts = 0;
		Transaction tx = null;
		try {
			Session session = SessionUtil.getSession();
			tx = session.beginTransaction();
			iCounts = ud.totalCount();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return iCounts;
	}

}
