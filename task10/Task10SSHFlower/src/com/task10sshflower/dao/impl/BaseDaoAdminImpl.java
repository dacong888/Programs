package com.task10sshflower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.Admin;
import com.task10sshflower.vo.Users;

public class BaseDaoAdminImpl extends HibernateDaoSupport implements BaseDao<Admin> {

	@Override
	public List<Admin> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> find(String key) {
		String hql = "from Admin where username = ?";
		 List<Admin> list =  this.getHibernateTemplate().find(hql, key);
		 return list;
	}

	@Override
	public Admin get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Admin entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findEx(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
