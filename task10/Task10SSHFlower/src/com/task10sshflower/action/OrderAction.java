package com.task10sshflower.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task10sshflower.service.TradeService;

public class OrderAction  extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = -5475394538145390662L;
	private TradeService tradeService = new TradeService();
	HttpServletRequest request;
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
	 * 向数据库中添加用户订单信息
	 * @return
	 */
	public String orderTrade()
	{
		tradeService.orderSubmit(request);
		request.setAttribute("OrderTradeState", true);
		return "ordertrade";
	}

}
