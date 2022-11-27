package com.example.mockito_hw;

import com.example.mockito_hw.model.Employee;
import com.example.mockito_hw.service.DepartmentService;
import com.example.mockito_hw.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
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

    private static final Employee EMPLOYEE_1 = new Employee("roman", "romanov", 1, 10000);
    private static final Employee EMPLOYEE_2 = new Employee("ivan", "ivanov", 2, 5000);
    private static final Employee EMPLOYEE_3 = new Employee("egor", "egorov", 3, 2500);

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private DepartmentService departmentService;

    @Test
    public void getEmployeesByDepartment() {
        employeeService.addEmployee(EMPLOYEE_1);
        employeeService.addEmployee(EMPLOYEE_2);
        employeeService.addEmployee(EMPLOYEE_3);
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = new ArrayList<>();
        actual.add(EMPLOYEE_1);
        actual.add(EMPLOYEE_2);
        actual.add(EMPLOYEE_3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getSumSalaryByDepartment() {
        Mockito.when(departmentService.getSumSalaryByDepartment(anyInt())).thenReturn(5000L);
        Assertions.assertEquals(departmentService.getSumSalaryByDepartment(1), 5000);

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
        employeeService.addEmployee(EMPLOYEE_1);
        employeeService.addEmployee(EMPLOYEE_2);
        employeeService.addEmployee(EMPLOYEE_3);
        departmentService = new DepartmentService(employeeService);
        HashMap<Integer, Set<Employee>> expected = departmentService.getEmployeesInDepartment(1);
        Set<Employee> employees = new HashSet<>(Set.of(EMPLOYEE_1, EMPLOYEE_2));
        HashMap<Integer, Set<Employee>> actual = departmentService.getEmployeesInDepartment(1);
        Assertions.assertEquals(expected,actual);


    }

}
