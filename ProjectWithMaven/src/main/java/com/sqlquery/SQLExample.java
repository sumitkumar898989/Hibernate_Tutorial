package com.sqlquery;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import com.tut.*;

public class SQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		//SQL query
		
		String q = "select * from student";
		NativeQuery nq=s.createSQLQuery(q);
		List<Object[]> list = nq.list();
		
		for(Object[] st:list)
		{
			System.out.println(Arrays.deepToString(st));
		}
		
		
		s.close();
		factory.close();

	}

}
