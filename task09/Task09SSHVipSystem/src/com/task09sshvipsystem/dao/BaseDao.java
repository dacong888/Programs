package com.task09sshvipsystem.dao;

import java.util.List;
/**
 * 定义通用泛型DAO接口
 * @author Songbin
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public List<T> find();

	public List<T> find(String key);

	public T get(Integer key);

	public void add(T entity);

	public void delete(T entity);

	public void delete(String hql, String key);

	public void edit(T entity);

	public List<T> findAll(String hql);

}
