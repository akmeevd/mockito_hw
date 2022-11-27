package com.example.mockito_hw.controller;

import com.example.mockito_hw.model.Employee;
import com.example.mockito_hw.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable("id") int department) {
        return this.departmentService.getEmployeesByDepartment(department);
    }

    @GetMapping("/{id}/salary/sum")
    public long getSumSalaryByDepartment(@PathVariable("id") int department) {
        return this.departmentService.getSumSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public long getMinSalaryByDepartment(@PathVariable("id") int department) {
        return this.departmentService.getMinSalaryByDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    public long getMaxSalaryByDepartment(@PathVariable("id") int department) {
        return this.departmentService.getMaxSalaryByDepartment(department);
    }
}
