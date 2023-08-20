package com.anwar.bookapp.repository;

// Importing required classes
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anwar.bookapp.model.Department;
 
// Annotation
@Repository
 
// Class
public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
}