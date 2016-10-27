package com.task09sshvipsystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task09sshvipsystem.dao.BaseDao;
import com.task09sshvipsystem.vo.Vip;
/**
 * VIP通用泛型DAO接口实现
 * @author Songbin
 *
 */
public class BaseDaoVipImpl extends HibernateDaoSupport implements BaseDao<Vip> {

	@Override
	public Vip get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Vip entity) {
		
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Vip entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vip> find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Vip entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vip> findAll(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vip> find() {
		String hql = "from Vip";
		return this.getHibernateTemplate().find(hql);
	}

}
