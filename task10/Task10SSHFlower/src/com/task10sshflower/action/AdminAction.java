package com.task10sshflower.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task10sshflower.pojo.AdminOptr;
import com.task10sshflower.service.TradeService;
import com.task10sshflower.vo.Category;
import com.task10sshflower.vo.Orders;
import com.task10sshflower.vo.Users;

public class AdminAction  extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 4378860545329161226L;
	private TradeService tradeService = new TradeService();
	HttpServletRequest request;
	private AdminOptr adminOptr = new AdminOptr();
	/**
	 * @return the adminOptr
	 */
	public AdminOptr getAdminOptr() {
		return adminOptr;
	}

	/**
	 * @param adminOptr the adminOptr to set
	 */
	public void setAdminOptr(AdminOptr adminOptr) {
		this.adminOptr = adminOptr;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	
	/**
	 * 列举用户列表
	 * @return
	 */
	public String listUser()
	{
		List<Users> list = tradeService.getUsers();
		if (list == null) {
			request.setAttribute("UserNullState", true);
		}else
		{
			request.setAttribute("UserState", list);
		}
		
		return "admin";
	}
	
	/**
	 * 列举订单列表
	 * @return
	 */
	public String listOrder()
	{
		List<Orders> list = tradeService.getOrders();
		if (list == null) {
			request.setAttribute("OrderNullState", true);
		}else
		{
			request.setAttribute("OrderState", list);
		}
		
		return "admin";
	}
	
	/**
	 * 列举商品列表
	 * @return
	 */
	public String listGoods()
	{
		List<Category> list = tradeService.getGoods();
		if (list == null) {
			request.setAttribute("GoodsNullState", true);
		}else
		{
			request.setAttribute("GoodsState", list);
		}
		
		return "admin";
	}
	
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUser()
	{
		tradeService.deleteUser(adminOptr.getId());
		return "admin";
	}
	
	
	/**
	 * 删除订单
	 * @return
	 */
	public String deleteOrder()
	{
		tradeService.deleteOrder(adminOptr.getId());
		return "admin";
	}
	
	
	/**
	 * 删除商品
	 * @return
	 */
	public String deleteGoods()
	{
		tradeService.deleteGoods(adminOptr.getId());
		return "admin";
	}
	
	
	

}
