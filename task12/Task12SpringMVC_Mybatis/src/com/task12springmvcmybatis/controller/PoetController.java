package com.task12springmvcmybatis.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.task12springmvcmybatis.service.RetrivalService;
import com.task12springmvcmybatis.vo.Poetries;
import com.task12springmvcmybatis.vo.Poets;

@Controller
public class PoetController {

	@Resource
	private RetrivalService rs;

	@RequestMapping("retrival")
	public ModelAndView retrival(String select, String content, HttpServletRequest request) {

		List<Poets> list = rs.getResult(select, content);
		System.out.println(list.size());
		for(Poets p : list){
			System.out.println(p.getName());
			for(Poetries ps : p.getPoetries())
			{
				System.out.println(ps.getTitle());
			}
		}
		request.setAttribute("select", select);
		request.setAttribute("PoetsRetrivalResult", list);
		return new ModelAndView("result");
	}
}
