package com.task08spring02ssh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.task08spring02ssh.entity.Poetries;
import com.task08spring02ssh.pojo.RetrievalContent;
import com.task08spring02ssh.service.PoetService;

public class RetrievalAction extends ActionSupport implements ServletRequestAware, ModelDriven<RetrievalContent> {

	private static final long serialVersionUID = 3017288043369864274L;
	// JSP页面传入数据
	private RetrievalContent retrievalContent = new RetrievalContent();
	private HttpServletRequest request;
	
	// 业务层数据
	private PoetService poetService;
	public void setPoetService(PoetService poetService) {
		this.poetService = poetService;
	}

	public String execute() {
		List<Poetries> list = poetService.find(retrievalContent.getSelect(), retrievalContent.getContent());
		request.setAttribute("poetContent", list);
		request.setAttribute("poetSelect", retrievalContent.getSelect());
		return "result";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public RetrievalContent getModel() {
		return retrievalContent;
	}

}
