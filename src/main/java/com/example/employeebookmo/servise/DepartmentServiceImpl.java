package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;
import com.example.employeebookmo.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeServiceImpl employeeService;
    private List<Employee> employeeMap;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService, List<Employee> employeeMap) {
        this.employeeService = employeeService;
        this.employeeMap = employeeMap;
    }


    @Override
    public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return employeeMap.stream().filter(employee ->
                        employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return employeeMap.stream().filter(employee1 ->
                        employee1.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> printAllByDepartment(Integer departmentId) {

        List<Employee> result = employeeMap.stream().filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> result = employeeMap.stream().collect(Collectors.toList());
        return result;
    }
}
