package com.task10sshflower.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task10sshflower.service.TradeService;

public class RegisterAction  extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 590484245285547005L;
	private TradeService tradeService = new TradeService();

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
		// TODO Auto-generated method stub
		
	}

}
