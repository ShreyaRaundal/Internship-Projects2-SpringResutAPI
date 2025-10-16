package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	 
	// http://localhost:8080/student
	// {
	//   "name": "Shreya",
	//   "email": "shreya@example.com",
	//   "age": 22
	// }
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		Student returnedStudent = repository.save(student);
		return returnedStudent;
	}
	
	// http://localhost:8080/fetchStudent/1
	@GetMapping("/fetchStudent/{id}")
	public Student findStudentById(@PathVariable int id) {
		Optional<Student> optional = repository.findById(id);
		Student s = optional.get();
		return s;
	}
	
	// http://localhost:8080/findAll
	@GetMapping("/findAll")
	public List<Student> findAllStudent() {
		List<Student> students = repository.findAll();
		return students;
	}
	
	// http://localhost:8080/deleteStudent?id=1
	@DeleteMapping("/deleteStudent")
	public String deleteStudentById(@RequestParam int id) {
		Optional<Student> optional = repository.findById(id);
		if (optional.isPresent()) {
			Student s = optional.get();
			repository.delete(s);
			return "Student with id: " + id + " is deleted";
		}
		return "Student with id: " + id + " is not exist";
	}
	
	
	// http://localhost:8080/findWithPhone/989898775
	@GetMapping("/findWithPhone/{phone}")
	public Student findStudentWithPhone(@PathVariable long phone) {
		Student s = repository.findByPhone(phone);
		return s;
	}
}
