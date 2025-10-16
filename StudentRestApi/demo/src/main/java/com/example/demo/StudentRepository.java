package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByPhone(long phone);
	List<Student> findByName(String name);
	

	@Query("select s from Student s")
	List<Student> getAllStudent();
	
	@Query("select s from Student s where s.phone = :ph")
	Student getStudentByPhone(long phno);
}
