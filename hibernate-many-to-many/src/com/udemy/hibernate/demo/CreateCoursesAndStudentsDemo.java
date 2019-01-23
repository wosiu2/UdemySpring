package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Course;
import com.udemy.hibernate.demo.entity.Instructor;
import com.udemy.hibernate.demo.entity.InstructorDetail;
import com.udemy.hibernate.demo.entity.Review;
import com.udemy.hibernate.demo.entity.Student;


public class CreateCoursesAndStudentsDemo {

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
			
			var student=session.get(Student.class, 2);
			
			var course1=new Course("Spring2");
			var course2=new Course("TypeScript2");
			var course3=new Course("Angular2");
			
			student.addCourse(course1);
			student.addCourse(course2);
			student.addCourse(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			

			
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
