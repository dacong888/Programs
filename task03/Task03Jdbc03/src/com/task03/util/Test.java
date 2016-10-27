package com.task03.util;

import java.sql.Connection;
import java.util.List;
import com.task03.dao.StudentDao;
import com.task03.dao.student.impl.StudentDaoImpl;
import com.task03.dto.Student;

/*
 * 测试类，用于检测JDBC程序下对学生表的添加、查询以及删除操作。
 * 其中：
 * 		1. 工程在运行前需要添加连接jar包。jar包已经放在目录下，需要手动添加到Java Bulid Path下的Libraries。
 * 		2. 数据库连接需要首先连接数据库。其中连接信息写在名称为：dbconfig.properties文件下。不同的机器配置不同，在测试时需要修改一下。
 */
public class Test {
	
	public static void main(String[] args){
		
		//初始化插入数据库的数据
		int[] stu_id = {1,2,3,4,5,6,7,8,9,10};
		String[] stu_name = {"赵飞", "钱峰", "孙开", "李红", "周挺", "吴爽", "郑智", "王峰", "冯亮", "陈英"};
		int[] stu_age = {20,21,18,14,12,16,22,10,30,11};
		String[] stu_gender = {"男", "男", "男", "女", "男", "女", "男", "男", "男", "女"};
		String[] stu_addr = {"北京市朝阳区", "北京市海淀区", "北京市丰台区", "北京市东城区", "北京市西城区", "北京市石景山区", "北京市顺义区", "北京市房山区", "北京市大兴区", "北京市昌平区"};
		
		//创建连接
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().doConnection();
			StudentDao sd = new StudentDaoImpl();
			Student stu = new Student();
			
			System.out.println("---------------------------------向表中插入10个学生数据---------------------------------");
			//向数据表中插入10条学生数据记录
			for(int i = 0; i < stu_name.length; i++){
				stu.setId(stu_id[i]);
				stu.setName(stu_name[i]);
				stu.setAge(stu_age[i]);
				stu.setGender(stu_gender[i]);
				stu.setAddr(stu_addr[i]);
				sd.add(conn, stu);
			}
			
			List<Student> showFind = sd.show(conn);
			for(Student s: showFind){
				System.out.println(s.toString());
			}
			showFind.clear();
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("---------------------------------查询年龄大于15岁的男生---------------------------------");
			//在学生表中，查询年龄大于15岁的男生
			stu.setGender("男");
			stu.setAge(15);
			showFind = sd.find(conn, stu);
			for (Student s : showFind) {
				System.out.println(s.toString());
			}
			showFind.clear();
			
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("---------------------------------删除学生表中的所有男生---------------------------------");
			//删除学生表中所有的男生
			stu.setGender("男");
			sd.delete(conn, stu);
			showFind = sd.show(conn);
			for(Student s: showFind){
				System.out.println(s.toString());
			}
			showFind.clear();
			conn.close();
			System.out.println("---------------------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (conn != null) {
					conn.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	}
}
