package com.example.mockito_hw.service;

import com.example.mockito_hw.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(int department) {
        return employeeService.findEmployeeByDepartment(department);
    }

    public long getSumSalaryByDepartment(int department) {
        return employeeService.getEmployees().
                stream().
                filter(s -> s.getDepartment() == department).
                mapToLong(Employee::getSalary).sum();
    }

    public long getMinSalaryByDepartment(int department) {
        return employeeService.getEmployees().
                stream().
                filter(s -> s.getDepartment() == department).
                mapToLong(Employee::getSalary).min().getAsLong();
    }

    public long getMaxSalaryByDepartment(int department) {
        return employeeService.getEmployees().
                stream().
                filter(s -> s.getDepartment() == department).
                mapToLong(Employee::getSalary).max().getAsLong();
    }


    public HashMap<Integer, Set<Employee>> getEmployeesInDepartment(int department) {
        HashMap<Integer, Set<Employee>> hashMap = new HashMap<>();
        Set<Employee> employees = employeeService.getEmployees().stream().filter(s -> s.getDepartment() == department).collect(Collectors.toSet());
        hashMap.put(department, employees);
        return hashMap;
    }


}
