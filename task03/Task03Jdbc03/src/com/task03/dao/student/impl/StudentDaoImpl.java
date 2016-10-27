package com.task03.dao.student.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.task03.dao.StudentDao;
import com.task03.dto.Student;

public class StudentDaoImpl implements StudentDao {

	/**
	 * 向表中添加信息
	 */
	@Override
	public void add(Connection conn, Student stu) throws SQLException {
		PreparedStatement ps = conn.prepareCall("insert into t_students(stu_id, stu_name, stu_age, stu_gender, stu_address) values (?,?,?,?,?)");
		ps.setInt(1, stu.getId());
		ps.setString(2, stu.getName());
		ps.setInt(3, stu.getAge());
		ps.setString(4, stu.getGender());
		ps.setString(5, stu.getAddr());
		ps.execute();
	}

	/**
	 * 查找信息
	 */
	@Override
	public List<Student> find(Connection conn, Student stu) throws SQLException {
		String sql = "select * from t_students where stu_gender= ? and stu_age > ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getGender());
		ps.setInt(2, stu.getAge());
		ResultSet result = ps.executeQuery();
		LinkedList<Student> listStu= new LinkedList<>();
		Student stuInfo = null;
		while(result.next()){
			stuInfo  = new Student();
			stuInfo.setId(result.getInt("stu_id"));
			stuInfo.setName(result.getString("stu_name"));
			stuInfo.setAge(result.getInt("stu_age"));
			stuInfo.setGender(result.getString("stu_gender"));
			stuInfo.setAddr(result.getString("stu_address"));
			listStu.add(stuInfo);
		}
		
		return listStu;
	}

	/**
	 * 刪除信息
	 */
	@Override
	public void delete(Connection conn, Student stu) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from t_students where stu_gender = ?");
		ps.setString(1, stu.getGender());
		ps.execute();
	}

	
	/**
	 * 显示表数据
	 */
	@Override
	public List<Student> show(Connection conn) throws SQLException {
		String sql = "select * from t_students";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = null;
		LinkedList<Student> listStu = new LinkedList<>();
		Student student = null;
		try {
			rs = ps.executeQuery();
			while(rs.next()){
				student = new Student();
				student.setId(rs.getInt("stu_id"));
				student.setName(rs.getString("stu_name"));
				student.setAge(rs.getInt("stu_age"));
				student.setGender(rs.getString("stu_gender"));
				student.setAddr(rs.getString("stu_address"));
				listStu.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listStu;
	}
}




















