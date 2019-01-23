package com.udemy.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int id = 1;
			session.beginTransaction();
			var myStudent = session.get(Student.class, id);
			
			myStudent.setLastName("ScoobyDoo");
			
			session.getTransaction().commit();
			//-----------------------------------
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();		
			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List theStudents) {
		for (var student : theStudents) {
			System.out.println(student);
		}
	}

}
