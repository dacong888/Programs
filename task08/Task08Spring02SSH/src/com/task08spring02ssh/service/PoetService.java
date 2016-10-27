package com.task08spring02ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.task08spring02ssh.dao.impl.BaseDaoImpl;
import com.task08spring02ssh.entity.Poetries;
/**
 * 业务层实现
 * @author Songbin
 *
 */
@Transactional
public class PoetService {

	private BaseDaoImpl baseDaoImpl;

	public void setBaseDaoImpl(BaseDaoImpl baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}

	public List<Poetries> find(String select, String content) {
		String hql = null;
		if (select.equals("作者")) {
			hql = "from Poetries p where p.poets.name = ?";
		} else if (select.equals("题目")) {
			hql = "from Poetries p where p.title = ?";
		} else if (select.equals("内容")) {
			hql = "from Poetries p where p.content like ?";
			content = "%" + content + "%";
		}
		return baseDaoImpl.find(hql, content);
	}

}
