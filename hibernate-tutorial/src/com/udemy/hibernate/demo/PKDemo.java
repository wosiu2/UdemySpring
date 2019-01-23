package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.demo.entity.Student;

public class PKDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object");
			
			Student tempStudent1=new Student("mich", "Woc", "wosfsiu2@wwwwqqw.pl");
			Student tempStudent2=new Student("mi", "Wo", "woffdssiu2@wwwwqqw.pl");
			Student tempStudent3=new Student("m", "W", "wosifffu2@wwwwqqw.pl");
			
			session.beginTransaction();
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
