package com.example.homework18.controller;

import com.example.homework18.model.Employee;
import com.example.homework18.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firsName, @RequestParam String lastName) {
        return employeeService.add(firsName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firsName, @RequestParam String lastName) {
        return employeeService.remove(firsName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firsName, @RequestParam String lastName) {
        return employeeService.find(firsName, lastName);
    }

    @GetMapping("/")
    public List<Employee> list() {
        return employeeService.list();
    }
}
