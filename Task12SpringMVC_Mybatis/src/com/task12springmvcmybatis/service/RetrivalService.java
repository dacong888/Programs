package com.task12springmvcmybatis.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.task12springmvcmybatis.dao.PoetsMapper;
import com.task12springmvcmybatis.vo.Poetries;
import com.task12springmvcmybatis.vo.Poets;
/**
 * 搜索诗词内容的业务层
 * @author Admins
 *
 */
public class RetrivalService {
	@Resource
	private PoetsMapper pm;

	public void getResult(String select, String content, HttpServletRequest request) {
		List<Poets> list = null;
		if (select.equals("题目")) {
			list = pm.getContentByTitle(content);
			request.setAttribute("PoetsRetrivalResult", list);
		} else if (select.equals("作者")) {
			list = pm.getContentByName(content);
			request.setAttribute("PoetsRetrivalResult", list);
		} else if (select.equals("内容")) {
			List<Poetries> ls = pm.getContentByContent(content);
			request.setAttribute("PoetsRetrivalResult", ls);
		}
	}
	
}
