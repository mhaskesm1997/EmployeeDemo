package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Employee;
import com.example.demo.Model.EmployeeRequest;
import com.example.demo.Services.ImpEmployeeService;

@RestController
@RequestMapping("Api/base/")
public class EmployeeController
{
	@Autowired
	private ImpEmployeeService employeeService;
	
	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		employeeService.addEmployee(employeeRequest);
		return new ResponseEntity<String>("Employee Added",HttpStatus.OK);
	}
	
	@GetMapping("getAllEmployees")
	public List<Employee> getAllEmployees()
	{
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}
	
	
	@DeleteMapping("deleteEmployee{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id)
	{
		boolean employee = employeeService.findTheEmployee(id);
		if(employee)
		{
			employeeService.deleteTheEmployee(id);
			return new ResponseEntity<String>("Employee Added",HttpStatus.OK);
		}
		else
		{
			
			return new ResponseEntity<String>("Employee Already Deleted",HttpStatus.OK);
		}
	}
	
	
	@PutMapping("updatetheEmployeeDepartment{id}and{departmentName}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id,@PathVariable String departmentName)
	{
		employeeService.updateTheEmployeeDepartment(id, departmentName);
		return new ResponseEntity<String>("Employee Department Updated",HttpStatus.OK);
	}
	
	

}
