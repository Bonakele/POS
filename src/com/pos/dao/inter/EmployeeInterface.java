package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Employee;

public interface EmployeeInterface {
	
	public int saveOrUpdate(Employee employee);
	public Employee getEmployeeByEmpNum(int empNum);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeBySA_Id(String saId);

}
