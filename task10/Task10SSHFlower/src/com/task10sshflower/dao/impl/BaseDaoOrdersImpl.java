package com.task10sshflower.dao.impl;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task10sshflower.dao.BaseDao;
import com.task10sshflower.vo.Orders;

import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;

public class BaseDaoOrdersImpl extends HibernateDaoSupport implements BaseDao<Orders> {

	@Override
	public List<Orders> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders get(Integer key) {
		return this.getHibernateTemplate().load(Orders.class, key);
	}

	@Override
	public void add(Orders entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(Orders entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Orders entity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> findAll() {
		String hql = "from Orders";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Orders get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getLast() {
		String hql = "from Orders order by ordersid desc";
		return (Orders) this.getHibernateTemplate().find(hql).get(0);
	}

	@Override
	public void delete(Integer id) {
		Orders orders = get(id);
		this.getHibernateTemplate().delete(orders);
	}

	@Override
	public List<Orders> findEx(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
