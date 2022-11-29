package com.example.mockito_hw;

import com.example.mockito_hw.model.Employee;
import com.example.mockito_hw.service.EmployeeService;
import org.junit.jupiter.api.*;;
import java.util.ArrayList;
import java.util.List;


public class EmployeeServiceTest {
    private EmployeeService employeeService;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private int department;
    private int id;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
        employee1 = new Employee("artem", "artemov", 1, 1000);
        employee2 = new Employee("victor", "victorov", 2, 2000);
        employee3 = null;
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
    }

    @Test
    public void shouldAddEmployee() {
        Assertions.assertTrue(employeeService.getEmployees().contains(employee1));
    }


    @Test
    public void shouldDeleteEmployeeById() {
        employeeService.deleteEmployeeById(employee1.getId());
        Assertions.assertFalse(employeeService.getEmployees().contains(employee1));
    }

    @Test
    public void shouldFindEmployeeById() {
        Assertions.assertEquals(employee2, employeeService.findEmployeeById(employee2.getId()));
    }

    @Test
    public void shouldFindEmployeeByDepartment() {
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = employeeService.findEmployeeByDepartment(department);
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    public void shouldGetAllStudents() {
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddEmployeeLikeNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee3));
    }
}
