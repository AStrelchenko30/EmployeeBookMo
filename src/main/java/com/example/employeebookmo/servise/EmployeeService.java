package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;

import java.util.Collection;
import java.util.List;


public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int workPlace);

    Employee remove(String firstName, String lastName, int salary, int workPlace);

    Employee find(String firstName, String lastName, int salary, int workPlace);
    List<Employee> getAllEmployee();



    /*Employee findEmployeeWithMaxSalary(Integer departmentId);

    Employee findEmployeeWithMinSalary(Integer departmentId);
    List<Employee> printAllByDepartment(Integer departmentId);


    Collection<Employee> findAll();*/
}