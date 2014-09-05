package com.pos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.EmployeeInterface;
import com.pos.helper.Helper;
import com.pos.model.Client;
import com.pos.model.Employee;

public class EmployeeImplementation implements EmployeeInterface {
	SessionFactory session = Helper.getSessionFactory();

	public int saveOrUpdate(Employee employee) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(employee);

		sess.getTransaction().commit();
		sess.close();

		return employee.getEmpNum();
	}

	
	public Employee getEmployeeByEmpNum(int empNum) {

		Session sess = session.openSession();
		Query query = (Query) sess.getNamedQuery("Employee.ByEmpNum");
		query.setInteger(0, empNum);
		Employee employee = (Employee) query.uniqueResult();

		return employee;

	}
	
	public Employee getEmployeeBySA_Id(String saId) {

		Session sess = session.openSession();
		Query query = (Query) sess.getNamedQuery("Employee.BySA_Id");
		query.setString(0, saId);
		Employee employee = (Employee) query.uniqueResult();

		return employee;

	}

	public List<Employee> getAllEmployees() {

		Session sess = session.openSession();

		 Query query = (Query) sess.getNamedQuery("Employee.ByAllEmployees");
		List<Employee> list = query.list();

		return list;
	}
}
