package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//this calss is used for embeddable demo using Student and Certificate
public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Student student1 = new Student();
        student1.setId(1123);
        student1.setName("SK");
        student1.setCity("LKO");
        
        Certificate certi = new Certificate();
        certi.setCourse("Java");
        certi.setDuration("2 month");
        
        Student student2 = new Student();
        student2.setId(1124);
        student2.setName("AL");
        student2.setCity("JK");
        
        Certificate certi1 = new Certificate();
        certi1.setCourse("Hibernate");
        certi1.setDuration("1 month");
        
        student1.setCerti(certi);
        student2.setCerti(certi1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        //objects save
        
        s.save(student1);
        s.save(student2);
        
        
        
        tx.commit();
        session.close();
        factory.close();

	}

}
