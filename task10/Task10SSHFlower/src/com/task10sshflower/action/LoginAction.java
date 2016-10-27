package com.task10sshflower.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task10sshflower.dao.impl.BaseDaoUsersImpl;
import com.task10sshflower.pojo.AdminLogin;
import com.task10sshflower.pojo.AdminRegister;
import com.task10sshflower.pojo.UserLogin;
import com.task10sshflower.pojo.UserRegister;
import com.task10sshflower.service.TradeService;
import com.task10sshflower.vo.Admin;
import com.task10sshflower.vo.Users;

public class LoginAction extends ActionSupport implements ServletRequestAware, SessionAware {
	private static final long serialVersionUID = 6651098558259290916L;
	private TradeService tradeService = new TradeService();
	private UserLogin userLogin = new UserLogin();
	private UserRegister userRegister = new UserRegister();
	private HttpServletRequest request;
	private Map<String, Object> session;
	private AdminRegister adminRegister = new AdminRegister();
	private AdminLogin adminLogin = new AdminLogin();
	
	private BaseDaoUsersImpl baseDaoUsersImpl;
	/**
	 * @return the adminLogin
	 */
	public AdminLogin getAdminLogin() {
		return adminLogin;
	}

	/**
	 * @param adminLogin the adminLogin to set
	 */
	public void setAdminLogin(AdminLogin adminLogin) {
		this.adminLogin = adminLogin;
	}

	/**
	 * @return the adminRegister
	 */
	public AdminRegister getAdminRegister() {
		return adminRegister;
	}

	/**
	 * @param adminRegister the adminRegister to set
	 */
	public void setAdminRegister(AdminRegister adminRegister) {
		this.adminRegister = adminRegister;
	}

	/**
	 * @return the userLogin
	 */
	public UserLogin getUserLogin() {
		return userLogin;
	}

	/**
	 * @param userLogin the userLogin to set
	 */
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	/**
	 * @return the tradeService
	 */
	public TradeService getTradeService() {
		return tradeService;
	}

	/**
	 * @param tradeService the tradeService to set
	 */
	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	public UserRegister getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}
	
	
	private void transObject(UserRegister ur, Users u)
	{
		u.setUserName(ur.getUserName());
		u.setAddress(ur.getAddress());
		u.setEmail(ur.getEmail());
		u.setPassWord(ur.getPassword());
		u.setPhoneNO(ur.getPhoneNO());
		u.setPwdQuestion(ur.getPwdQuestion());
		u.setPwdQuestionAnswer(ur.getPwdQuestionAnswer());
		u.setRealName(ur.getRealName());
	}

	/**
	 * 用户注册
	 * @return
	 */
	public String Register()
	{
		Users user = new Users();
		transObject(userRegister, user);
		tradeService.UserRegister(user);
		request.setAttribute("UserRegisterState", true);
		return "register";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String Login()
	{
		Boolean b = tradeService.UserLogin(userLogin);
		if (b) {
			// 添加session，用于显示登录用户信息。
			session.put("UserLoginSession", userLogin);
			return "shopping";
		}
		
		
		request.setAttribute("UserLoginState", false);
		return "flowers";
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	public String Logout()
	{
		//获取session,并清空。
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "index";
	}
	
	/**
	 * 验证注册管理员口令
	 * @param adminRegister
	 * @return
	 */
	private Boolean verifyPin(AdminRegister adminRegister)
	{
		if (adminRegister.getPassword().equals(adminRegister.getRetryPassword())) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 管理员注册
	 * @return
	 */
	public String AdminRegister()
	{
		if (!verifyPin(adminRegister)) {
			request.setAttribute("AdminLoginRegisterState", false);
			return "adminlogin";
		}
		
		Admin admin = new Admin();
		admin.setUserName(adminRegister.getUserName());
		admin.setPassWord(adminRegister.getPassword());
		tradeService.AdminRegister(admin);
		
		request.setAttribute("AdminLoginRegisterState", true);
		return "adminlogin";
		
	}
	
	
	/**
	 * 管理员登录
	 * @return
	 */
	public String AdminLogin()
	{
		Boolean b = tradeService.AdminLogin(adminLogin);
		if (b) {
			session.put("AdminLoginSession", adminLogin);
			return "admin";
		}
		
		request.setAttribute("AdminLoginState", false);
		return "adminlogin";
	}
	
}
























