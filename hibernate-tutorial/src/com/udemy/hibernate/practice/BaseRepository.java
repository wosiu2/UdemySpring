package com.udemy.hibernate.practice;


import java.util.Collection;
import org.hibernate.Session;
import com.udemy.hibernate.practice.entity.Employee;

public class BaseRepository {

	private Session session;

	public BaseRepository(Session session) {

		this.session = session;
		session.beginTransaction();
	}

	public Collection<Employee> findByCompany(String company) {
		String query="from Employee e where e.company='"+company+"'";
		Collection<Employee> result = session.createQuery(query).getResultList();
		return result;

	}

	public void delete(int id) {

		var entity=session.get(Employee.class, id);
		session.delete(entity);

	}

	public void update(Employee entity) {
		session.update(entity);
	}

	public void create(Employee entity) {
		session.save(entity);

	}

	public void save() {
		session.getTransaction().commit();
	}

	public void cancel() {
		session.getTransaction().rollback();
	}

}
