package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {

			int theId=1;
			session.beginTransaction();
			
			var instructor=session.get(Instructor.class, theId);

			if(instructor!=null) {
				session.delete(instructor);
			}
			session.getTransaction().commit();

		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
