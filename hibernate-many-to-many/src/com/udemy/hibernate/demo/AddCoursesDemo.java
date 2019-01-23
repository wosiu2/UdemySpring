package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;
import com.udemy.hibernate.demo.entity.Review;
import com.udemy.hibernate.demo.entity.Student;


public class AddCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			var tempCourse=new Course("Hibernate");
			
			session.save(tempCourse);
			
			var student1=new Student("abc","bca","ww@ww.ww");
			var student2=new Student("bca","abc","ww@ww.ww");
			
			tempCourse.addStudnet(student1);
			tempCourse.addStudnet(student2);
			
			session.save(student1);
			session.save(student2);
			
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
