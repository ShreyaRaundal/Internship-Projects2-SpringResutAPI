package com.springrest.employerestapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/emp")
@RestController
public class EmployeController {
	
	@Autowired
	private EmployeRepository repository;
	
	
	@PostMapping
	public Employee SaveEmployee(@RequestBody Employee employe) {
		Employee returnedEmployee = repository.save(employe);
		return returnedEmployee;
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employe) {
		return repository.save(employe);
	}
	
	// http://localhost:8080/emp/fetch/101
	@GetMapping("/fetch/{id}")
	public Employee findEmployeById(@PathVariable int id) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			Employee e = optional.get();
			return e;
		}
		return null;
	}
	
	// Find all — http://localhost:8080/emp/findAll
	@GetMapping("/findAll")
	public List<Employee> findAllEmployee() {
	    return repository.findAll();
	}
	
	// Find by salary — http://localhost:8080/emp/findBySalary/50000
    @GetMapping("/findBySalary/{sal}")
    public List<Employee> repositoryfindBySalary(@PathVariable double sal) {
	     return repository.findBySalary(sal);
     }
    
    
 // Custom query: find employee with salary greater than given value
    @GetMapping("/salaryGreaterThan/{sal}")
    public List<Employee> getEmployeeWithSalaryGreaterThan(@PathVariable double sal) {
        return repository.getEmployeeWithSalaryGreaterThan(sal);
    }

    // Custom query: find employees by department name
    @GetMapping("/findByDept/{dept}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String dept) {
        return repository.getEmployeeByDepartment(dept);
    }

}
