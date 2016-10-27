package com.task09sshvipsystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task09sshvipsystem.dao.BaseDao;
import com.task09sshvipsystem.vo.User;
/**
 * 用户通用泛型DAO接口实现
 * @author Songbin
 *
 */
public class BaseDaoUserAuthImpl extends HibernateDaoSupport implements BaseDao<User> {

	@Override
	public User get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User entity) {
		
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(String hql, String key) {
		this.getHibernateTemplate().delete(hql, key);
	}

	@Override
	public void edit(User entity) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find(String key) {
		String hql = "from User u where u.username = ?";
		return this.getHibernateTemplate().find(hql, key);		
	}

	@Override
	public void delete(User entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find() {
		String hql = "from User";
		return this.getHibernateTemplate().find(hql);
	}

}
