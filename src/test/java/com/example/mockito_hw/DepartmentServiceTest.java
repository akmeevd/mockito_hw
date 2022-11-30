package com.example.mockito_hw;

import com.example.mockito_hw.model.Employee;
import com.example.mockito_hw.service.DepartmentService;
import com.example.mockito_hw.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("roman", "romanov", 1, 10000);
        employee2 = new Employee("ivan", "ivanov", 1, 5000);
        employee3 = new Employee("egor", "egorov", 3, 2500);
        Mockito.when(employeeService.getEmployees()).thenReturn(List.of(employee1, employee2, employee3));
    }

    @Test
    public void getEmployeesByDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Assertions.assertEquals(employees, departmentService.getEmployeesByDepartment(1));
    }

    @Test
    public void getSumSalaryByDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Assertions.assertEquals(employees.get(0).getSalary() +
                        employees.get(1).getSalary(),
                departmentService.getSumSalaryByDepartment(1));
    }

    @Test
    public void getMinSalaryByDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Assertions.assertEquals(Math.min(employees.get(0).getSalary(), employees.get(1).getSalary()),
                departmentService.getMinSalaryByDepartment(1));
    }

    @Test
    public void getMaxSalaryByDepartment() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Assertions.assertEquals(Math.max(employees.get(0).getSalary(), employees.get(1).getSalary()),
                departmentService.getMaxSalaryByDepartment(1));
    }

    @Test
    public void getEmployeesInDepartment() {
        Set<Employee> employeesSet = new HashSet<>(Set.of(employee1, employee2));
        HashMap<Integer, Set<Employee>> employees = new HashMap<>();
        employees.put(1, employeesSet);
        Assertions.assertEquals(employees, departmentService.getEmployeesInDepartment(1));
    }
}

