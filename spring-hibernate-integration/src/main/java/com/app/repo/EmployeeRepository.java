package com.app.repo;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeRepository {

	public Boolean saveOrUpdate(Employee employee);
	
	public Boolean deleteEmployee(Integer id);
	
	public Employee getEmployeeById(Integer id);
	
	public List<Employee> getEmployees();
	
}
