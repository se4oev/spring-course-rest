package ru.se4oev.spring.rest.controller;

import org.springframework.web.bind.annotation.*;
import ru.se4oev.spring.rest.entity.Employee;
import ru.se4oev.spring.rest.exception_handling.NoSuchEmployeeException;
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

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");

        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");

        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

}
