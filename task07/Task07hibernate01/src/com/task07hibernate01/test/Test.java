package com.task07hibernate01.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.task07hibernate01.entity.Poetries;
import com.task07hibernate01.entity.Poets;
import com.task07hibernate01.util.SessionConnection;

public class Test {

	// 1、［使用HQL实现］输出数据中名字为三个字的诗人列表及其诗词的数量统计。格式如：姓名 － 诗词数量
	public static void stepOne(Session session) {
		try {
			// 1 选出三个字符的诗人名称以及对应主键ID
			String sql = "select new Poets(p1.id, p1.name) from Poets p1 where char_length(p1.name) = 3";
			@SuppressWarnings("unchecked")
			List<Poets> listPoets = (List<Poets>) session.createQuery(sql).list();

			// 2
			String sqlTitleCounts = "select count(*) from Poetries p2 where p2.poet_id = :pid";
			Query query = session.createQuery(sqlTitleCounts);
			Iterator<Poets> iteratorPoets = listPoets.iterator();
			Poets pTemp = null;
			int iReturn = 1;
			while (iteratorPoets.hasNext()) {
				pTemp = iteratorPoets.next();
				query.setInteger("pid", pTemp.getId());
				if (iReturn % 20 == 0) {
					System.out.println(pTemp.getName() + "-" + query.uniqueResult());
				} else {
					System.out.print(pTemp.getName() + "-" + query.uniqueResult() + '\t');
				}
				iReturn++;
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			// 关闭资源
			session.close();
		}

	}

	// 2、分页输出诗人李白所有诗词的标题，要求每10个标题分为1页。
	public static void stepTwo(Session session) {
		try {
			String sqlId = "select p.id from Poets p where p.name = '李白'";
			@SuppressWarnings("unchecked")
			List<Integer> listId = (List<Integer>) session.createQuery(sqlId).list();
			String sqlTitle = "select p.title from Poetries p where p.poet_id = :pid";
			Query query = session.createQuery(sqlTitle);
			query.setInteger("pid", listId.get(0));
			int listTitleCounts = query.list().size();

			int iPage = 0;
			if (listTitleCounts % 10 == 0) {
				iPage = listTitleCounts / 10;
			} else {
				iPage = listTitleCounts / 10 + 1;
			}
			System.out.println('\n' + "诗人李白相关的数据总共" + iPage + "页。");
			List<String> listPoetTitle = null;
			Iterator<String> iterator = null;
			for (int i = 1; i <= iPage; i++) {
				System.out.println("第" + i + "页内容");
				query = session.createQuery(sqlTitle).setFirstResult((i - 1) * 10).setMaxResults(10);
				query.setInteger("pid", listId.get(0));
				listPoetTitle = new LinkedList<>();
				listPoetTitle = query.list();
				iterator = listPoetTitle.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			session.close();
		}

	}

	// 3、［使用关联映射实现］输出某一个诗人所有的诗词前15个字（包括标点符号），这个诗人的名字要求用户输入，敲回车后进行查询操作。
	public static void stepThree(Session session) {
		try {
			// 输入作者
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入诗人：");

			// 按照输入的作者为条件进行查询
//			String sql = "select substring(p2.content,1,15) from Poets p1, Poetries p2 where p1.id=p2.poet_id and p1.name = :poetName";
//			Query query = session.createQuery(sql);
//			String poetName = sc.next();
//			query.setString("poetName", poetName);
//			List<String> list = query.list();
//			// 输出
//			if (list.size() == 0) {
//				System.out.println("没有找到诗人" + poetName + "的相关内容...");
//			} else {
//				System.out.println("-----------诗句内容-----------");
//				for (String l : list) {
//					System.out.println(l);
//				}
//			}
			String sql = "from Poets p where p.name = :poetName";
			Query query = session.createQuery(sql);
			String poetName = sc.next();
			query.setString("poetName", poetName);
			@SuppressWarnings("unchecked")
			List<Poets> list = query.list();
			Poets poets = list.get(0);
			Iterator<Poetries> iterator = poets.getPeotries().iterator();
			while(iterator.hasNext()){
				
				System.out.println(iterator.next().getContent().substring(0, 15));
				
			}

			sc.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			session.close();
		}
	}

	public static void main(String[] args) {
		// 步骤一
//		Session session = SessionConnection.getSession();
//		stepOne(session);
//
//		// 步骤二
//		session = SessionConnection.getSession();
//		stepTwo(session);
//
//		// 步骤三
//		 session = SessionConnection.getSession();
//		 stepThree(session);
	}
}
