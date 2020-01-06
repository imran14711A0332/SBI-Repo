package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		//Activate HB FrameWork
		cfg=new Configuration();
		//read hibernate cfg,xml file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create SeesionFactory Object
		factory=cfg.buildSessionFactory();
		//open SessionFactoy with db s/w
		ses=factory.openSession();
		
		//create object for our domain class
		emp=new Employee();
		emp.setEid(332);
		emp.setFirstname("shaik");
		emp.setLastname("imran");
		emp.setEmail("imran3213@gmail.com");
		
		try {
			tx=ses.beginTransaction();
			ses.save(emp);
			tx.commit();
			System.out.println("SaveObjectTest.main()");
		}//try
		catch(Exception e) {
			tx.rollback();
		}//catch
		//close object
		ses.close();
		factory.close();
	}//main

}//class
