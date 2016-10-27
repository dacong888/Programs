package com.task09sshvipsystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task09sshvipsystem.dao.BaseDao;
import com.task09sshvipsystem.vo.Consume;
/**
 * VIP购物通用泛型DAO接口实现
 * @author Songbin
 *
 */
public class BaseDaoConsumeImpl extends HibernateDaoSupport implements BaseDao<Consume> {

	@Override
	public Consume get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Consume entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Consume entity) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Consume> find(String key) {
		String hql = "from Consume c where c.name = ?";
		return this.getHibernateTemplate().find(hql, key);
	}

	@Override
	public void delete(Consume entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consume> findAll(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consume> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
