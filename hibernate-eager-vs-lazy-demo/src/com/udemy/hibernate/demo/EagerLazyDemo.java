package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {

			int id=1;
			session.beginTransaction();
			var instructor=session.get(Instructor.class,id);

			System.out.println("Ww"+instructor);
			System.out.println("Ww"+instructor.getCourses());
	
			session.getTransaction().commit();

			System.out.println("Ww"+instructor.getCourses());
			
		}catch (Exception e) {
			if(session.isOpen()) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
