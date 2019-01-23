package com.udemy.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			
			Student tempStudent=new Student("michal", "Woch", "wosiu2@wwwwqqw.pl");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
