package dao;

import java.util.List;
import model.Employee;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {
	public void insert(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();	
			}
			
		} finally {
			session.close();
		}
	}
	
	public void update(Employee position) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(position);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();	
			}
			
		} finally {
			session.close();
		}
	}
	
	public Employee find(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();

		Employee employee;
		
		try {
			employee = (Employee) session.load(Employee.class, id);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return employee;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> fetchAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> employees = null;

		try {
			Query query = session.createQuery("from Employee e");
			employees = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return employees;
	}
}
