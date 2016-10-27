package com.task10sshflower.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.task10sshflower.pojo.GoodsDesc;
import com.task10sshflower.pojo.GoodsNameRetrival;
import com.task10sshflower.pojo.GoodsPriceRetrival;
import com.task10sshflower.pojo.GoodsTypeRetrival;
import com.task10sshflower.service.TradeService;
import com.task10sshflower.vo.Goods;
import com.task10sshflower.vo.OrderDetails;

public class GoodsAction  extends ActionSupport implements ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 8023999788048272087L;
	private TradeService tradeService = new TradeService();
	GoodsTypeRetrival goodsTypeRetrival = new GoodsTypeRetrival();
	GoodsPriceRetrival goodsPriceRetrival = new GoodsPriceRetrival();
	GoodsDesc goodsDesc = new GoodsDesc();
	GoodsNameRetrival goodsNameRetrival = new GoodsNameRetrival();
	/**
	 * @return the goodsNameRetrival
	 */
	public GoodsNameRetrival getGoodsNameRetrival() {
		return goodsNameRetrival;
	}

	/**
	 * @param goodsNameRetrival the goodsNameRetrival to set
	 */
	public void setGoodsNameRetrival(GoodsNameRetrival goodsNameRetrival) {
		this.goodsNameRetrival = goodsNameRetrival;
	}


	HttpServletRequest request;
	
	/**
	 * @return the goodsDesc
	 */
	public GoodsDesc getGoodsDesc() {
		return goodsDesc;
	}

	/**
	 * @param goodsDesc the goodsDesc to set
	 */
	public void setGoodsDesc(GoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}


	/**
	 * @return the goodsPriceRetrival
	 */
	public GoodsPriceRetrival getGoodsPriceRetrival() {
		return goodsPriceRetrival;
	}

	/**
	 * @param goodsPriceRetrival the goodsPriceRetrival to set
	 */
	public void setGoodsPriceRetrival(GoodsPriceRetrival goodsPriceRetrival) {
		this.goodsPriceRetrival = goodsPriceRetrival;
	}

	/**
	 * @return the goodsTypeRetrival
	 */
	public GoodsTypeRetrival getGoodsTypeRetrival() {
		return goodsTypeRetrival;
	}

	/**
	 * @param goodsTypeRetrival the goodsTypeRetrival to set
	 */
	public void setGoodsTypeRetrival(GoodsTypeRetrival goodsTypeRetrival) {
		this.goodsTypeRetrival = goodsTypeRetrival;
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
	 * 解析名称
	 * @param select
	 * @return
	 */
	private String parseName(String select)
	{
		String name;
		switch (select) {
		case "goods_bh":
			name = "百合";
			break;
		case "goods_knx":
			name = "康乃馨";
			break;
		case "goods_mtl":
			name = "马蹄莲";	
			break;
		case "goods_mg":
			name = "玫瑰";
			break;
		case "goods_xrk":
			name = "向日葵";
			break;
		case "goods_yjx":
			name = "郁金香";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}
	
	/**
	 * 按照类型搜索
	 * @return
	 */
	public String goodsTypeSearch()
	{
		String name = parseName(goodsTypeRetrival.getSelect());
		List<Goods> goods = tradeService.searchByType(name);
		request.setAttribute("GoodsSearchResultState", goods);
		return "goodsdesc";
	}
	
	/**
	 * 按照价格搜索
	 * @return
	 */
	public String goodsPriceSearch()
	{
		List<Goods> goods = tradeService.searchByPrice(goodsPriceRetrival.getSelect());
		request.setAttribute("GoodsSearchResultState", goods);
		return "goodsdesc";
	}
	
	
	/**
	 * 按照名称搜索
	 * @return
	 */
	public String goodsNameSearch()
	{
		List<Goods> goods = tradeService.searchByName(goodsNameRetrival.getName());
		request.setAttribute("GoodsSearchResultState", goods);
		return "goodsdesc";
	}
	
	
	/**
	 * 添加购物车
	 * @return
	 */
	public String addUserCart()
	{
		//查找传入的商品名称是否存在于数据库，如果存在，则加入购物车。如果不存在，页面跳转提示。
		Boolean isOk = tradeService.addCart(goodsDesc.getName(), request);
		if (!isOk) {
			// 数据库中不存在页面推荐商品，跳转提示页面。
			return "fail";
		}
		
		// 商品添加购物车成功
		return "success"; 
	}
	
	/**
	 * 选购商品信息
	 * @return
	 */
	public String showGoodsDetails()
	{
		List<OrderDetails> orderDetails = tradeService.goodsOrderInfo(request);
		if (orderDetails == null) {
			request.setAttribute("OrderDetailsState", false);
		}else
		{
			request.setAttribute("OrderDetails", orderDetails);
		}
		
		return "goodsdetails";
	}
	
	

	
	
	

}
