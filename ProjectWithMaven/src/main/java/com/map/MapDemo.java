package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//commented code is for one to one mapping
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //Creating Question
        
       // Question q1= new Question();
       // q1.setQuestionId(1212);
        //q1.setQuestion("What is Java");
        
        //Creating Answer
        
       // Answer answer = new Answer();
       // answer.setAnswer("Java is a Programming language");
       // answer.setAnswerId(343);
       // answer.setQuestion(q1);
        
        //q1.setAnswer(answer);
        
        //Creating Question
        
        //Question q2= new Question();
        //q2.setQuestionId(1213);
        //q2.setQuestion("What is Collection Framework");
        
        //Creating Answer
        
        //Answer answer1 = new Answer();
        //answer1.setAnswer("API to work with objects in Java");
       // answer1.setAnswerId(344);
       // answer1.setQuestion(q2);
        
        //q2.setAnswer(answer1);
        
        //this is added to check one to many mapping
        //Answer answer1 = new Answer();
        //answer1.setAnswer("With the help of java we can create softwares");
       // answer1.setAnswerId(344);
        //answer1.setQuestion(q1);
        
        //Answer answer2 = new Answer();
        //answer2.setAnswer("Java has different types of frameworks");
        //answer2.setAnswerId(345);
       // answer2.setQuestion(q1);
        
       //List<Answer> list = new ArrayList<Answer>();
       // list.add(answer);
       // list.add(answer1);
       // list.add(answer2);
        
      //  q1.setAnswers(list);
        
        
        
      //this is added to check one to many mapping
      //session
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        //save
        //s.save(q1);
        //s.save(q2);
        //s.save(answer);  // this line is added to handle postgress exception
        //s.save(answer1); // this line is added to handle postgress exception
        
        //this is added to check one to many mapping
        //s.save(q1);
       // s.save(answer);
       // s.save(answer1); // this line is added to handle postgress exception
       // s.save(answer2); // this line is added to handle postgress exception
        
        //tx.commit();
        
        //fetching
       // Question que = (Question)s.get(Question.class, 1212);
        //System.out.println(que.getQuestion());
        //System.out.println(que.getAnswer().getAnswer());
        
      //fetching one to many
		/*
		 * Question que = (Question)s.get(Question.class, 1212);
		 * System.out.println(que.getQuestion()); for(Answer a:que.getAnswers()) {
		 * System.out.println(a.getAnswer()); }
		 */
         
         Question que = (Question)s.get(Question.class, 1212);
         System.out.println(que.getQuestion());
         System.out.println(que.getQuestionId());
         //Lazy
         //System.out.println(que.getAnswers().size());// when we call size the answer table is called and data is loaded
        
        s.close();
        factory.close();
        
        

	}

}
