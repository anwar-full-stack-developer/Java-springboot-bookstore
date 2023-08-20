package com.anwar.bookapp.service;

import java.util.List;

import com.anwar.bookapp.model.Department;

public interface DepartmentService {
// save operation
    Department saveDepartment(Department department);
 
    // read operation
    List<Department> fetchDepartmentList();
 
    // update operation
    Department updateDepartment(Department department, Long departmentId);
 
    // delete operation
    void deleteDepartmentById(Long departmentId);
}
