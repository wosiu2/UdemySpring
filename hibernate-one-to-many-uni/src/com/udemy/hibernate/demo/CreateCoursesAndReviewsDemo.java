package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;
import com.udemy.hibernate.demo.entity.Review;


public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			var tempCourse=new Course("Hibernate");
			tempCourse.addReview(new Review("Great"));
			tempCourse.addReview(new Review("Great!"));
			tempCourse.addReview(new Review("Great!!"));
			tempCourse.addReview(new Review("Great!!!"));
			
			session.save(tempCourse);
			
			session.getTransaction().commit();

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
