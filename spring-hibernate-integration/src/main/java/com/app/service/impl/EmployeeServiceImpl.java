package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public Boolean saveOrUpdate(Employee employee) {
		return employeeRepo.saveOrUpdate(employee);
	}

	public Boolean deleteEmployee(Integer id) {
		return employeeRepo.deleteEmployee(id);
	}

	public Employee getEmployeeById(Integer id) {
		return employeeRepo.getEmployeeById(id);
	}

	public List<Employee> getEmployees() {
		return employeeRepo.getEmployees();
	}

}
