package com.example.employeebookmo.servise;

import com.example.employeebookmo.Employee;
import com.example.employeebookmo.exceptions.EmployeeAlreadyAddException;
import com.example.employeebookmo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeMap;


    int arraySize = 6;

    public EmployeeServiceImpl(DepartmentServiceImpl departmentService) {
        this.employeeMap = new ArrayList<>(List.of(new Employee("Олег", "Харатьян", 100_000, 1),
                new Employee("Елена", "Воробей", 36_000, 1),
                new Employee("Анна", "Стрельченко", 56_000, 2),
                new Employee("Иван", "Иванов", 50_000, 2),
                new Employee("Жан-Клод", "Ван Дам", 560_000, 3),
                new Employee("Жан", "Рено", 750_000, 3),
                new Employee("Доннальд", "Трамп", 10_000, 4),
                new Employee("Жак", "Кусто", 145_000, 4)

                ));

    }
    public List<Employee> getAllEmployee() {

        return new ArrayList<Employee>(employeeMap.stream().toList());

    }


    @Override
    public Employee add(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.contains(employee.getFullName())) {
            throw new EmployeeAlreadyAddException();
        }
        employeeMap.add(employee);
        return employee;
    }


    @Override
    public Employee remove(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.contains(employee.getFullName())) {
            employeeMap.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int workPlace) {
        Employee employee = new Employee(
                firstName,
                lastName,
                salary,
                workPlace
        );
        if (employeeMap.contains(employee.getFullName())) {
            return employee;

        }
        throw new EmployeeNotFoundException();

    }

}

   /* @Override
 public Employee findEmployeeWithMaxSalary(Integer departmentId) {
        return employeeMap.values().stream().filter(employee ->
                        employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);


    }

    @Override
    public Employee findEmployeeWithMinSalary(Integer departmentId) {
        return employeeMap.values().stream().filter(employee1 ->
                        employee1.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> printAllByDepartment(Integer departmentId) {
        List<Employee> result = employeeMap.values().stream().filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> result = employeeMap.values().stream().collect(Collectors.toList());
        return result;
    }*/

