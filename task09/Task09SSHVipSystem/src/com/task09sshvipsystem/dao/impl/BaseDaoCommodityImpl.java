package com.task09sshvipsystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.task09sshvipsystem.dao.BaseDao;
import com.task09sshvipsystem.vo.Commodity;
/**
 * 商品通用泛型DAO接口实现
 * @author Songbin
 *
 */
public class BaseDaoCommodityImpl extends HibernateDaoSupport implements BaseDao<Commodity> {

	@Override
	public Commodity get(Integer key) {
		return this.getHibernateTemplate().get(Commodity.class, key);

	}

	@Override
	public void add(Commodity entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(String hql, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Commodity entity) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> find(String key) {
		String hql = "from Commodity c where c.commodityName like ?";
		String content = "%" + key + "%";
		return this.getHibernateTemplate().find(hql, content);
	}

	@Override
	public void delete(Commodity entity) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> findAll(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> find() {
		String hql = "from Commodity";
		return this.getHibernateTemplate().find(hql);
	}

}
