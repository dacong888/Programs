package com.task08spring02ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task08spring02ssh.dao.BaseDao;
import com.task08spring02ssh.entity.Poetries;
/**
 * DAO层实现类
 * @author Songbin
 *
 */
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Poetries> find(String hql, String condition) {
		return this.getHibernateTemplate().find(hql, condition);
	}

}
