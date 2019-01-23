package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {

			var tempInstructor=new Instructor(
					"Michal","Woch","ww@ww.pl");
			
			var detail=new InstructorDetail(
					"www.ww.pl","qweerr");
			
			tempInstructor.setDetail(detail);
			
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();

		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
