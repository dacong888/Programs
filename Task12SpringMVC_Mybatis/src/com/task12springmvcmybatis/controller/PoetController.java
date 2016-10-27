package com.task12springmvcmybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.task12springmvcmybatis.service.RetrivalService;
/**
 * springmvc控制层
 * @author Admins
 *
 */
@Controller
public class PoetController {

	@Resource
	private RetrivalService rs;

	@RequestMapping("retrival")
	public ModelAndView retrival(String select, String content, HttpServletRequest request) {

		rs.getResult(select, content, request);
		request.setAttribute("select", select);
		return new ModelAndView("result");
	}
}
