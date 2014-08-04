package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Employee;

public interface EmployeeInterface {
	
	public int save(Employee employee);
	public Employee getEmployeeById(int empNum);
	public List<Employee> getAllEmployees();


}
