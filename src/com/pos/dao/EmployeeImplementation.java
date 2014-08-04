package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.EmployeeInterface;
import com.pos.helper.Helper;
import com.pos.model.Employee;

public class EmployeeImplementation implements EmployeeInterface {
	public int save(Employee employee) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(employee);

		sess.getTransaction().commit();
		sess.close();

		return employee.getEmpNum();
	}

	public Employee getEmployeeById(int empNum) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Employee employee = (Employee) sess.load(Employee.class, empNum);

		return employee;

	}

	public List<Employee> getAllEmployees() {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		org.hibernate.Query query = sess.createQuery("from Employee");
		List<Employee> list = query.list();

		return list;
	}
}
