package com.task11springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.task11springmvc.pojo.User;
import com.task11springmvc.service.UserLoginService;
import com.task11springmvc.util.UserContext;
/**
 * SpringMVC登录业务流程。
 * @author Songbin
 *
 */
@Controller
public class TestController {
	private UserLoginService userLoginService;
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(User user, HttpServletRequest request)
	{		
		userLoginService = (UserLoginService) UserContext.getBean("userSercie");
		Boolean rv = userLoginService.validatedLogin(user);
		if (rv) {
			request.setAttribute("username", user.getUsername());
			request.setAttribute("password", user.getPassword());
			return new ModelAndView("message");
		}else
		{
			return new ModelAndView("error");
		}
	}
	
	
	
}
