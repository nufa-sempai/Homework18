package com.example.homework18.service;

import com.example.homework18.exception.EmployeeAlreadyAddedException;
import com.example.homework18.exception.EmployeeNotFoundException;
import com.example.homework18.exception.EmployeeStorageIsFullException;
import com.example.homework18.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 3;

    private final List<Employee> employees = new ArrayList<>(SIZE);

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
