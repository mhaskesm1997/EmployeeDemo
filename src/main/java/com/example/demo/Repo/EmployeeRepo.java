package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
	Employee findById(int id);
	Employee findByAddress(String address);

}
