package com.task09sshvipsystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task09sshvipsystem.pojo.UserAuth;
import com.task09sshvipsystem.pojo.UserReg;
import com.task09sshvipsystem.service.VipSystemService;
import com.task09sshvipsystem.vo.User;

/**
 * 用户操作模块
 * @author Songbin
 *
 */
public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -8654189563304724635L;
	private HttpServletRequest request;
	private VipSystemService vipSystemService = new VipSystemService();
	private UserAuth userAuth = new UserAuth();
	private UserReg userReg = new UserReg();

	public UserReg getUserReg() {
		return userReg;
	}

	public void setUserReg(UserReg userReg) {
		this.userReg = userReg;
	}

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	public VipSystemService getVipSystemService() {
		return vipSystemService;
	}

	public void setVipSystemService(VipSystemService vipSystemService) {
		this.vipSystemService = vipSystemService;
	}

	// 系统维护(1.增加用户)
	public String userAdd() {
		vipSystemService.userAdd(userReg);
		request.setAttribute("addUserState", true);
		return "maintain";
	}

	// 系统维护(2.查看用户)
	public String userGet() {
		List<User> list = vipSystemService.userGet();
		request.setAttribute("UserState", list);
		return "maintain";
	}

	// 系统维护(3.删除用户)
	public String userDelete() {
		User registerUser = new User();
		registerUser.setUsername(userAuth.getUsername());
		vipSystemService.userDelete(registerUser);
		request.setAttribute("users", vipSystemService.userGet());
		return "maintain";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
