package com.udemy.hibernate.practice;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.udemy.hibernate.practice.entity.Employee;

public class HibernatePractice {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		var repo = new BaseRepository(factory.getCurrentSession());
		//Unit of work
		try {

			var ent = repo.findByCompany("ABC");
			for (var e : ent) {
				e.setCompany("CBA");
				repo.update(e);
			}
			repo.save();
			
		} catch (Exception e) {
			repo.cancel();
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
