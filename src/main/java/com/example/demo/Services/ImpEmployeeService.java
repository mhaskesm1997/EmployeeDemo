package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Domain.Employee;
import com.example.demo.Model.EmployeeRequest;

@Service
public interface ImpEmployeeService
{
	void addEmployee(EmployeeRequest employeeRequest);
	
	List<Employee> getAllEmployees();
	
	boolean findTheEmployee(int id);
	
	void deleteTheEmployee(int id);
	
	void updateTheEmployeeDepartment(int id,String departmentName);
	
	void saveEmployee(EmployeeRequest employeeRequest);
	
	boolean findThePresenceOfEmployee(EmployeeRequest employeeRequest);
	

}
