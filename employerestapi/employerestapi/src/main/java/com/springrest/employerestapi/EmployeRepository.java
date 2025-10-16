package com.springrest.employerestapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findBySalary(double salary);
	
	// Custom query of  JPQL
	@Query("SELECT e FROM Employee e WHERE e.salary > ?1")
	List<Employee> getEmployeeWithSalaryGreaterThan(double salary);
	
	// Another example (optional): find by department
	@Query("SELECT e FROM Employee e WHERE e.dept = ?1")
	List<Employee> getEmployeeByDepartment(String dept);
}
