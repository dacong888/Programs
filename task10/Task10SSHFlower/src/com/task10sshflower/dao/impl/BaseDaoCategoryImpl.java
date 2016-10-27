package com.task10sshflower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.Category;

public class BaseDaoCategoryImpl extends HibernateDaoSupport implements BaseDao<Category>{

	@Override
	public List<Category> find() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> find(String key) {
		String hql = "from Category where categoryname = ?";
		return this.getHibernateTemplate().find(hql, key);
	}

	@Override
	public Category get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		String hql = "from Category";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public Category get(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Category getLast() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Category> findEx(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
