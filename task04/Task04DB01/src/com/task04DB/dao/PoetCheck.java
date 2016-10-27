package com.task04DB.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.task04DB.dto.PoetInfo;

public interface PoetCheck {
	public List<PoetInfo> getResult(Connection conn, String content) throws SQLException;
}
