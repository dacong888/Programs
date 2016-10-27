package com.task03.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.task03.dto.Student;

/**
 *  定义学生类DAO接口。
 *  add：向表中添加数据。
 *  find：在表中查找数据。
 *  delete：删除指定表数据。
 *  show：显示表数据。
 */
public interface StudentDao {
	public void add(Connection conn, Student stu) throws SQLException;
	public List<Student> find(Connection conn, Student stu)throws SQLException;
	public void delete(Connection conn, Student stu)throws SQLException;
	public List<Student> show(Connection conn)throws SQLException;
}
