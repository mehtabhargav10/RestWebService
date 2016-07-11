package org.bhargav.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import org.bhargav.model.EmployeeBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

	public void addEmployee(EmployeeBean employeeBean)
	{
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		addEmployee(session, employeeBean);
		transaction.commit();
		session.close();
	}
	
	private void addEmployee(Session session,EmployeeBean employeeBean)
	{
		Employee employee = new Employee();
		employee.setName(employeeBean.getName());
		employee.setAge(employeeBean.getAge());
		session.save(employee);
	}
	
	public List<Employee> getEmployees()
	{
		Session session = SessionUtil.getSession();
		TypedQuery<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}
	
	public int deleteEmployee(int id)
	{
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from Employee where id = :id";
		TypedQuery<Employee> query = session.createQuery(hql, Employee.class);
		query.setParameter("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		transaction.commit();
		session.close();
		return rowCount;
	}
}
