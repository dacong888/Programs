package com.task12springmvcmybatis.dao;

import java.util.List;

import com.task12springmvcmybatis.vo.Poetries;
import com.task12springmvcmybatis.vo.Poets;

public interface PoetsMapper {

	// 测试
	// public Poet getUser(int id);

	public List<Poets> getContentByTitle(String content);

	public List<Poets> getContentByName(String content);

	public List<Poetries> getContentByContent(String content);
}
