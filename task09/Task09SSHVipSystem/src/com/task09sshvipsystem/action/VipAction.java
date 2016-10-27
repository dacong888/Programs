 package com.task09sshvipsystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task09sshvipsystem.pojo.VipConsume;
import com.task09sshvipsystem.pojo.Vips;
import com.task09sshvipsystem.service.VipSystemService;
import com.task09sshvipsystem.vo.Consume;
import com.task09sshvipsystem.vo.Vip;

/**
 * VIP操作模块
 * @author Songbin
 *
 */
public class VipAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1445785266450797200L;
	private HttpServletRequest request;

	private Vips vips = new Vips();
	private VipConsume vipConsume = new VipConsume();

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

	public Vips getVips() {
		return vips;
	}

	public void setVips(Vips vips) {
		this.vips = vips;
	}

	public VipConsume getVipConsume() {
		return vipConsume;
	}

	public void setVipConsume(VipConsume vipConsume) {
		this.vipConsume = vipConsume;
	}

	/**
	 * VIP管理
	 * @return
	 */
	public String vipManage() {
		vipSystemService.vipAdd(vips);
		request.setAttribute("VipAddState", true);
		return "vipmanage";
	}
	
	/**
	 * 列举VIP用户
	 * @return
	 */
	public String vipList()
	{
		List<Vip> list = vipSystemService.vipGet();
		request.setAttribute("VipList", list);
		return "vipmanage";
	}

	/**
	 * VIP用户注册
	 * @return
	 */
	public String vipGoodsRegister() {
		int i = vipSystemService.vipGoodsAdd(vipConsume);
		request.setAttribute("VipConsumeState", i);
		return "vipreg";
	}

	/**
	 * VIP购物查询
	 * @return
	 */
	public String vipGoodsSearch() {
		List<Consume> list = vipSystemService.vipGoodsGet(vips.getName());
		request.setAttribute("VipConsumeState", list.size() == 0);
		request.setAttribute("VipConsume", list);
		return "vipsearch";
	}

}
