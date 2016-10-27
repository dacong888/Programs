package com.task08spring02ssh.dao;

import java.util.List;

import com.task08spring02ssh.entity.Poetries;

public interface BaseDao {

	public List<Poetries> find(String hql, String condition);

}
