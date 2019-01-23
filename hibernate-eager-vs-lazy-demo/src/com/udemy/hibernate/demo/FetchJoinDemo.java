package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

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
			
			Query<Instructor> query=
					session.createQuery("select i from Instructor i "
							+"Join Fetch i.courses "
							+"where i.id=:theInstructorId"
							,Instructor.class);

			query.setParameter("theInstructorId", id);
			
			var instructor=query.getSingleResult();
			
			System.out.println("Ww"+instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Ww"+instructor.getCourses());

		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
