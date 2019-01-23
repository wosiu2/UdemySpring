package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			int theId=2;
			var detail=session.get(InstructorDetail.class, theId);
			
			System.out.println(detail.toString());
			
			System.out.println(detail.getInstructor());
			
			
			session.getTransaction().commit();

		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
