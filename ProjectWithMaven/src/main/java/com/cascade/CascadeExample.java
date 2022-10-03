package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(568);
		q1.setQuestion("What is cascading");
		
		Answer a1 = new Answer(23423,"in hybernate it is imp concept");
		Answer a2 = new Answer(255,"second answer");
		Answer a3 = new Answer(35,"third answer");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		Transaction tx=s.beginTransaction();
		
		
		s.save(q1);   // if we run this then question data is inserted in table but answer not stored to store answer data we have to do s.save(a1) to resolve this we have to use cascade in entity
		tx.commit();
		
		s.close();
		factory.close();

	}

}
