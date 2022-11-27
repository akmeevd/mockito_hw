package com.example.mockito_hw.service;

import com.example.mockito_hw.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Введите сотрудника");
        }
        employees.add(employee);
    }

    public void deleteEmployeeById(int id) {
        employees.removeIf(s -> s.getId() == id);
    }

    public Employee findEmployeeById(int id) {
        Employee employeeReturn = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeReturn = employee;
            }
        }
        return employeeReturn;
    }

    public List<Employee> findEmployeeByDepartment(int department) {
        return employees.stream().filter(s -> s.getDepartment() == department).collect(Collectors.toList());
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public String toString() {
        return "EmployeeService{" +
                "employees=" + employees +
                '}';
    }
}
