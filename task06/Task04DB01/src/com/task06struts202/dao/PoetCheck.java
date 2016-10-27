package com.task06struts202.dao;

import java.sql.SQLException;
import java.util.List;

import com.task06struts202.pojo.PoetInfo;

//定义获取检测信息接口
public interface PoetCheck {
	public List<PoetInfo> getPoetInfo(String tag, String content) throws SQLException;
}
