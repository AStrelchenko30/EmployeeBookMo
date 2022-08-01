package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);

    List<Employee> printAllByDepartment(Integer departmentId);

    Collection<Employee> findAll();


}
