package ru.se4oev.spring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.se4oev.spring.rest.entity.Employee;
import ru.se4oev.spring.rest.service.EmployeeService;

import java.util.List;

/**
 * Created by se4oev on 07.03.2022
 * Description:
 */
@RestController
@RequestMapping("/api")
public class MyRestController {

    EmployeeService employeeService;

    public MyRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
