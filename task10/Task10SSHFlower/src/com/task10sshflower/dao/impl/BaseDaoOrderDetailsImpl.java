package com.task10sshflower.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.OrderDetails;

public class BaseDaoOrderDetailsImpl extends HibernateDaoSupport implements BaseDao<OrderDetails> {

	@Override
	public List<OrderDetails> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(OrderDetails entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(OrderDetails entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(OrderDetails entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetails> findEx(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
