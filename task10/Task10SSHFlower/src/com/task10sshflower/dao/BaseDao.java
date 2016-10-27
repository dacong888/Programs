package com.task10sshflower.dao;

import java.util.List;

public interface BaseDao<T> {
	public List<T> find();

	public List<T> find(String key);
	
	public List<T> findEx(String key);

	public T get(Integer key);
	
	public T get(String key);

	public void add(T entity);

	public void delete(T entity);

	public void delete(String hql, String key);
	
	public void delete(Integer id);

	public void edit(T entity);

	public List<T> findAll();
	
	public T getLast();
}
