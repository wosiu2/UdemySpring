package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class EagerLazyNoSessionDemo {

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
			
			var courses=instructor.getCourses();
			System.out.println("Ww"+courses);
			
			session.getTransaction().commit();

		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
