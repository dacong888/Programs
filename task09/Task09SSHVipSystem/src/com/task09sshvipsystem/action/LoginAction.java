package com.task09sshvipsystem.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task09sshvipsystem.pojo.LoginRegister;
import com.task09sshvipsystem.pojo.UserAuth;
import com.task09sshvipsystem.service.VipSystemService;

/**
 * 登录模块
 * @author Songbin
 *
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, SessionAware {
	private static final long serialVersionUID = 1054658681557598961L;

	private HttpServletRequest request;

	private VipSystemService vipSystemService = new VipSystemService();

	private LoginRegister loginRegister = new LoginRegister();

	private UserAuth userAuth = new UserAuth();

	private Map<String, Object> session;

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public LoginRegister getLoginRegister() {
		return loginRegister;
	}

	public void setLoginRegister(LoginRegister loginRegister) {
		this.loginRegister = loginRegister;
	}

	public VipSystemService getVipSystemService() {
		return vipSystemService;
	}

	public void setVipSystemService(VipSystemService vipSystemService) {
		this.vipSystemService = vipSystemService;
	}

	// 用户登录
	public String userLogin() {
		Boolean rv = vipSystemService.verifyLogin(userAuth);
		if (rv) {
			session.put("UserLoginSession", userAuth);
			return "main";
		}

		request.setAttribute("UserLoginState", rv);
		return "index";
	}

	// 用户登出
	public String userLogout() {
		if (!session.isEmpty()) {
			session.clear();
		}

		return "index";
	}

	// 用户注册
	public String userRegister() {

		Boolean rv = vipSystemService.loginRegister(loginRegister);
		request.setAttribute("UserLoginRegisterState", rv);
		return "index";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
