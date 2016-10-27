package com.task09sshvipsystem.action;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task09sshvipsystem.pojo.GoodsCollect;
import com.task09sshvipsystem.pojo.GoodsRetrival;
import com.task09sshvipsystem.service.VipSystemService;
import com.task09sshvipsystem.vo.Commodity;
/**
 * 商品搜索模块
 * @author Songbin
 *
 */
public class CommodityAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -3560484476788839564L;
	private HttpServletRequest request;
	private GoodsCollect goodsCollect = new GoodsCollect();
	private GoodsRetrival goodsRetrival = new GoodsRetrival();
	private VipSystemService vipSystemService = new VipSystemService();

	public VipSystemService getVipSystemService() {
		return vipSystemService;
	}

	public void setVipSystemService(VipSystemService vipSystemService) {
		this.vipSystemService = vipSystemService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public GoodsCollect getGoodsCollect() {
		return goodsCollect;
	}

	public void setGoodsCollect(GoodsCollect goodsCollect) {
		this.goodsCollect = goodsCollect;
	}

	public GoodsRetrival getGoodsRetrival() {
		return goodsRetrival;
	}

	public void setGoodsRetrival(GoodsRetrival goodsRetrival) {
		this.goodsRetrival = goodsRetrival;
	}

	public String goodsInsert() {
		vipSystemService.goodsInsert(goodsCollect);
		request.setAttribute("goodsInsertState", true);
		return "goodsadd";
	}

	/**
	 * 判断输入是否为Integer类型数据
	 * @param str
	 * @return
	 */
	public boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入是否为Double类型数据
	 * @param str
	 * @return
	 */
	private boolean isDouble(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}

		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 输入类型控制比较，用于输入容错
	 * @param goodsRetrival
	 * @return
	 */
	private Boolean typeCompare(GoodsRetrival goodsRetrival) {

		if (goodsRetrival.getSelect().equals("goods_id")) {
			return isInteger(goodsRetrival.getContent());
		} else if (goodsRetrival.getSelect().equals("goods_price") || goodsRetrival.getSelect().equals("goods_agio")) {
			return isDouble(goodsRetrival.getContent());
		}

		return true;
	}

	/**
	 * 商品检索
	 * @return
	 */
	public String goodsRetrival() {
		if (typeCompare(goodsRetrival)) {
			List<Commodity> list = vipSystemService.getGoodsInfo(goodsRetrival);
			if (list != null && !list.isEmpty()) {
				request.setAttribute("goodsSearchState", list.get(0) != null);
			} else {
				request.setAttribute("goodsSearchState", false);
			}

			request.setAttribute("goodsSearch", list);
			return "goodssearch";
		} else {
			request.setAttribute("goodsInputSpellError", false);
			return "goodssearch";
		}

	}

}
