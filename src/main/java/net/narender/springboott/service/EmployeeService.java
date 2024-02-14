package net.narender.springboott.service;

import java.util.List;

import net.narender.springboott.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
    void deleteEmployeeById(long id);

}
