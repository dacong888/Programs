package com.task07hibernate01.test;

import java.time.chrono.JapaneseChronology;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.task07hibernate01.entity.Poetries;
import com.task07hibernate01.entity.Poets;
import com.task07hibernate01.util.SessionConnection;

public class UnitTest {
	
	
	@Test
	public void Test(){
		Session session = SessionConnection.getSession();
		
		String sql = "from Poets p where p.name = '杨玉环'";
		Query query = session.createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Poets> list = query.list();
		Poets poets = list.get(0);
		Iterator<Poetries> iterator = poets.getPeotries().iterator();
		while(iterator.hasNext()){
			
			System.out.println(iterator.next().getContent().substring(0, 15));
			
		}
		int i = 0;
		System.out.println(i);
		
		
	}
}
