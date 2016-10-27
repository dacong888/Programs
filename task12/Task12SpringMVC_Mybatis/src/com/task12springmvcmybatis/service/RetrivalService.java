package com.task12springmvcmybatis.service;

import java.util.List;

import javax.annotation.Resource;

import com.task12springmvcmybatis.dao.PoetsMapper;
import com.task12springmvcmybatis.vo.Poetries;
import com.task12springmvcmybatis.vo.Poets;

public class RetrivalService {
	@Resource
	private PoetsMapper pm;

	public List<Poets> getResult(String select, String content) {
		List<Poets> list = null;
		if (select.equals("题目")) {
			list = pm.getContentByTitle(content);
			// System.out.println(list);
		} else if (select.equals("作者")) {
			list = pm.getContentByName(content);
			// System.out.println(list);
		} else if (select.equals("内容")) {
			List<Poetries> ls = pm.getContentByContent(content);
			System.out.println(ls);
		}

		return list;
	}

}
