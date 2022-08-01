package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private Employee employee = new Employee("Георгий", "Альбертович", 86_000, 2);
    @Mock
    private DepartmentServiceImpl departmentService;
    private EmployeeServiceImpl employeeService;
    @BeforeEach
    public void setUp(){
        employeeService=new EmployeeServiceImpl(departmentService);
    }

    @Test
    void findEmployeeWithMaxSalary() {
        Mockito.when(departmentService.findEmployeeWithMaxSalary(1)).thenReturn(new Employee("Олег", "Харатьян", 100_000, 1));
        Employee expectedEmployee=new Employee("Олег", "Харатьян", 100_000, 1);
        assertEquals(departmentService.findEmployeeWithMaxSalary(1),expectedEmployee);
    }

    @Test
    void findEmployeeWithMinSalary() {
        Mockito.when(departmentService.findEmployeeWithMinSalary(1)).thenReturn(new Employee("Елена", "Воробей", 36_000, 1));
        Employee expectedEmployee=new Employee("Елена", "Воробей", 36_000, 1);
        assertEquals(departmentService.findEmployeeWithMinSalary(1),expectedEmployee);
    }

    @Test
    void printAllByDepartment() {
        List<Employee> actualList=new ArrayList<>();
        actualList.add(new Employee("Елена", "Воробей", 36_000, 1));
        actualList.add(new Employee("Олег", "Харатьян", 100_000, 1));
        Mockito.when(departmentService.printAllByDepartment(1)).thenReturn(actualList);
     assertEquals(departmentService.printAllByDepartment(1),actualList);
    }

    @Test
    void findAll() {
       Collection<Employee> actualList=new ArrayList<>();
        Collection<Employee> expectedList=departmentService.findAll();
        assertEquals(expectedList,actualList);
    }
}