package com.pagenation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLPagenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		//Query<Student> query = s.createQuery("from Student",Student.class);
		Query query = s.createQuery("from Student");
		
		
		//implementing pagination using hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);  // it will fetch the data from 0th row to 5th row
		List<Student> list = query.list();
		
		for(Student st:list )
		{
			System.out.println(st.getId()+":"+st.getName()+" :"+st.getCity());
		}
		
		
		s.close();
		factory.close();

	}

}
