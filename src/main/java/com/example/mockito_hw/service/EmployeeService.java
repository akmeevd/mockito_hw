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
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee findEmployeeByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                return employee;
            }
        }
        return null;
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
