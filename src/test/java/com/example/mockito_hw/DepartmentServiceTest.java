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

import static org.mockito.ArgumentMatchers.anyInt;

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
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
    }

    @Test
    public void getEmployeesByDepartment() {
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSumSalaryByDepartment() {
        Mockito.when(departmentService.getSumSalaryByDepartment(anyInt())).thenReturn(1000L);
        Assertions.assertEquals(departmentService.getSumSalaryByDepartment(1), 1000);
    }

    @Test
    public void getMinSalaryByDepartment() {
        Mockito.when(departmentService.getMinSalaryByDepartment(anyInt())).thenReturn(1000L);
        Assertions.assertEquals(departmentService.getMinSalaryByDepartment(1), 1000);
    }

    @Test
    public void getMaxSalaryByDepartment() {
        Mockito.when(departmentService.getMaxSalaryByDepartment(anyInt())).thenReturn(10000L);
        Assertions.assertEquals(departmentService.getMaxSalaryByDepartment(1), 10000);
    }

    @Test
    public void getEmployeesInDepartment() {
        departmentService = new DepartmentService(employeeService);
        HashMap<Integer, Set<Employee>> expected = departmentService.getEmployeesInDepartment(1);
        Set<Employee> employees = new HashSet<>(Set.of(employee1, employee2));
        HashMap<Integer, Set<Employee>> actual = new HashMap<>();
        actual.put(1, employees);
        Assertions.assertEquals(expected, actual);
    }
}

