package com.example.employeebookmo.controller;

import com.example.employeebookmo.Employee;
import com.example.employeebookmo.servise.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("department") int department) {
        service.add(firstName, lastName, salary, department);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Добавлен в ЛИСТ";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department){
        service.remove(firstName, lastName, salary, department);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Удален из списка";
    }
    @GetMapping("/find")
    public String fineEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("salary") int salary,
                               @RequestParam("department") int department) {
        service.find(firstName, lastName, salary, department);
        return "firstName:" + " " + firstName + " " + "lastName:" + " " + lastName + " " + "Уже есть в списке";
    }

    /*@GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }*/

}
