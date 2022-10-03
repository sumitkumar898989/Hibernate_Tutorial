package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * this calss is used to store student and address object in database
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //SessionFactory factory= new Configuration().configure().buildSessionFactory();
        SessionFactory factory=cfg.buildSessionFactory();
        //System.out.println(factory);
       // System.out.println(factory.isClosed());
        
        //creating object of student class
        Student st = new Student();
        st.setId(103);
        st.setName("AMIT");
        st.setCity("SITAMARHI");
        System.out.println(st);
        
        //Student st1 = new Student();
        //st1.setId(104);
        //st1.setName("RAJU");
        //st1.setCity("RAJOPATTI");
        //System.out.println(st1);
        
      //creating object of student class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
        //reading image
        
        FileInputStream fis = new FileInputStream("src/main/java/PieChart.jpeg");
        byte [] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(st);
        //session.save(st1);
        session.save(ad);
        session.getTransaction().commit();
        session.close();
        System.out.println("Done");
        
        
        
    }
}
