package com.dbusers.dao;

import java.util.List;

//泛型DAO接口
public interface BaseDao<T> {
	
	/**
	 * 保存数据
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 根据主键删除数据
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 编辑制定实例的详细信息
	 * @param entity
	 */
	public void edit(T entity);
	
	/**
	 * 根据主键获取对应实例
	 * @param id
	 * @return
	 */
	public T get(int id);
	
	/**
	 * 根据字段获取对应实例
	 * @param field
	 * @return
	 */
	public List<T> get(String field);
	
	/**
	 * 获取实体实例列表
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 统计总实体实例数量
	 * @return
	 */
	public int totalCount();

}
