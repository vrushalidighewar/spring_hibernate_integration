package com.app.service;

import java.util.List;



import com.app.entity.Employee;


public interface EmployeeService {

	public Boolean saveOrUpdate(Employee employee);
	
	public Boolean deleteEmployee(Integer id);
	
	public Employee getEmployeeById(Integer id);
	
	public List<Employee> getEmployees();
}
