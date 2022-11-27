package com.example.mockito_hw;

import com.example.mockito_hw.model.Employee;
import com.example.mockito_hw.service.EmployeeService;
import org.junit.jupiter.api.*;;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeServiceTest {

    private static EmployeeService employeeService = new EmployeeService();
    private static final Employee EMPLOYEE_1 = new Employee("artem", "artemov", 1, 1000);
    private static final Employee EMPLOYEE_2 = new Employee("victor", "victorov", 2, 2000);
    private static final Employee EMPLOYEE_3 = new Employee("pavel", "pavlov", 1, 3000);
    private static final Employee EMPLOYEE_NULL = null;
    private static final int DEPARTMENT_1 = 1;
    private static final int DEPARTMENT_2 = 1;
    private static final int DEPARTMENT_3 = 1;


    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests1")
    public void shouldAddEmployee(EmployeeService employeeService, Employee employee) {
        employeeService.addEmployee(employee);
        Assertions.assertTrue(employeeService.getEmployees().contains(employee));
    }


    @ParameterizedTest
    @MethodSource("provideParamsForTests2")
    public void shouldDeleteEmployeeById(EmployeeService employeeService, Employee employee, int id) {
        employeeService.addEmployee(employee);
        employeeService.deleteEmployeeById(id);
        Assertions.assertFalse(employeeService.getEmployees().contains(employee));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests2")
    public void shouldFindEmployeeById(EmployeeService employeeService,Employee employee, int id) {
        employeeService.addEmployee(employee);
        Assertions.assertEquals(employee, employeeService.findEmployeeById(id));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests3")
    public void shouldFindEmployeeByDepartment(EmployeeService employeeService,Employee employee,
                                               Employee employee1, Employee employee2, int department) {
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = employeeService.findEmployeeByDepartment(department);
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    public void shouldGetAllStudents() {
        employeeService.addEmployee(EMPLOYEE_1);
        employeeService.addEmployee(EMPLOYEE_2);
        employeeService.addEmployee(EMPLOYEE_3);
        List<Employee> expected = employeeService.getEmployees();
        List<Employee> actual = new ArrayList<>();
        actual.add(EMPLOYEE_1);
        actual.add(EMPLOYEE_2);
        actual.add(EMPLOYEE_3);
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenAddEmployeeLikeNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> employeeService.addEmployee(EMPLOYEE_NULL));
    }

    public static Stream<Arguments> provideParamsForTests1() {
        return Stream.of(Arguments.of(employeeService, EMPLOYEE_1));
    }

    public static Stream<Arguments> provideParamsForTests2() {
        return Stream.of(Arguments.of(employeeService,EMPLOYEE_1, 0));
    }
    public static Stream<Arguments> provideParamsForTests3() {
        return Stream.of(Arguments.of(employeeService,EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3, DEPARTMENT_1));
    }
}
