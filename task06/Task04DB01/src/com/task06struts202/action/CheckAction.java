package com.task06struts202.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.task06struts202.dao.PoetCheck;
import com.task06struts202.impl.PoetCheckImpl;
import com.task06struts202.pojo.CheckInfo;
import com.task06struts202.pojo.PoetInfo;

//定义action类，用于处理提交数据的业务
public class CheckAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	CheckInfo ci = new CheckInfo();
	private HttpServletRequest request;

	public String execute() {
		// 判断是否选择内容类型以及填写内容。假返回当前页。
		if ((!ci.getPoetContentSelect().equals("作者") || !ci.getPoetContentSelect().equals("内容")
				|| !ci.getPoetContentSelect().equals("题目")) && ci.getSearchPoet().trim().length() == 0) {
			return "index";
		}

		PoetCheck pc = new PoetCheckImpl();
		try {
			List<PoetInfo> pi = pc.getPoetInfo(ci.getPoetContentSelect(), ci.getSearchPoet());
			request.setAttribute("poetInfos", pi);
			request.setAttribute("poetSelct", ci.getPoetContentSelect());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "poets";
	}

	public CheckInfo getCi() {
		return ci;
	}

	public void setCi(CheckInfo ci) {
		this.ci = ci;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
