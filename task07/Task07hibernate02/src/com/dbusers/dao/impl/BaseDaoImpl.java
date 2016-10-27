package com.dbusers.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;

import com.dbusers.dao.BaseDao;
import com.dbusers.util.SessionUtil;

@SuppressWarnings("unchecked")

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;

	public BaseDaoImpl() {
		// 通过反射机制获取子类传递过来的实体类的类型信息
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity) {
		SessionUtil.getSession().save(entity);
	}

	@Override
	public void delete(int id) {
		SessionUtil.getSession().delete(get(id));
	}

	@Override
	public void edit(T entity) {
		SessionUtil.getSession().merge(entity);
	}

	@Override
	public T get(int id) {
		//return (T)SessionUtil.getSession().load(clazz, id);
		return (T)SessionUtil.getSession().get(clazz, id);
		
	}

	@Override
	public List<T> findAll() {
		String hql = "from " + clazz.getSimpleName();
		return (List<T>)SessionUtil.getSession().createQuery(hql).list();
	}

	@Override
	public int totalCount() {

		int count = 0;
		String hql = "select count(u) from " + clazz.getSimpleName() + " u";
		Long temp = (Long)SessionUtil.getSession().createQuery(hql).uniqueResult();
		if (temp != null) {
			count = temp.intValue();
		}
		
		return count;
	}

	@Override
	public List<T> get(String field) {
		String hql = "from " + clazz.getSimpleName() + " u where u.userName = :userName";
		Query query = SessionUtil.getSession().createQuery(hql);
		query.setString("userName", field);
		return query.list();
	}

	
}

























