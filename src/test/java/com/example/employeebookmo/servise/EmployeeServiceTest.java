package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private EmployeeServiceImpl employeeService;
    private Employee employee;
    DepartmentServiceImpl departmentService;
    private Employee employee2;
    List<Employee> actual;
    List<Employee> resultList;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl(departmentService);
        actual = new ArrayList<>();
        employee=new Employee("Георгий", "Альбертович", 86_000, 2);
        actual.add(employee);
        resultList = employeeService.getAllEmployee();
    }

    @Test
    void add() {
        resultList.add(new Employee("Георгий", "Альбертович", 86_000, 2));
        Employee expectedRes = resultList.get(resultList.size() - 1);
        Employee result = actual.get(actual.size() - 1);
        assertEquals(expectedRes, result);
    }

    @Test
    void remove() {
        resultList.add(new Employee("Георгий", "Альбертович", 86_000, 2));
        boolean result = resultList.remove(new Employee("Георгий", "Альбертович", 86_000, 2));
        boolean expected = actual.remove(new Employee("Георгий", "Альбертович", 86_000, 2));
        assertEquals(expected, result);
    }

    @Test
    void find() {
        resultList.add(new Employee("Георгий", "Альбертович", 86_000, 2));
        Employee result = employeeService.find("Георгий", "Альбертович", 86_000, 2);
        assertEquals(result, employee);
    }

    @Test
    void getAllEmployee() {
        assertEquals(resultList, actual);

    }
}