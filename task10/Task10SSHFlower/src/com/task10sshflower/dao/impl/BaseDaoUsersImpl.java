package com.task10sshflower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.Users;

public class BaseDaoUsersImpl extends HibernateDaoSupport implements BaseDao<Users>{

	@Override
	public List<Users> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> find(String key) {
		 String hql = "from Users where username = ?";
		 List<Users> list =  this.getHibernateTemplate().find(hql, key);
		 return list;
	}

	@Override
	public Users get(Integer key) {
		return this.getHibernateTemplate().get(Users.class, key);
	}

	@Override
	public void add(Users entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(Users entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Users entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {
		String hql = "from Users";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Users get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Users> findEx(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
