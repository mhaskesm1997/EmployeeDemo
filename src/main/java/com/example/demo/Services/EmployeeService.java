package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.Employee;
import com.example.demo.Model.EmployeeRequest;
import com.example.demo.Repo.EmployeeRepo;

@Service
public class EmployeeService implements ImpEmployeeService
{
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public void addEmployee(EmployeeRequest employeeRequest)
	{
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeRequest, employee);
		employeeRepo.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> allEmployees = employeeRepo.findAll();
		return allEmployees;
	}

	@Override
	public boolean findTheEmployee(int id) 
	{
		Employee employee = employeeRepo.findById(id);
		
		if(employee==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void deleteTheEmployee(int id)
	{
		
		employeeRepo.deleteById(id);
	}

	@Override
	public void updateTheEmployeeDepartment(int id, String departmentName)
	{
		Employee employee = employeeRepo.findById(id);
		employee.setDepartmentName(departmentName);
		employeeRepo.save(employee);
		
	}

}
