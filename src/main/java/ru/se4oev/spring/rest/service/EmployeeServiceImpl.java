package ru.se4oev.spring.rest.service;

import org.springframework.stereotype.Service;
import ru.se4oev.spring.rest.dao.EmployeeDAO;
import ru.se4oev.spring.rest.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by se4oev on 13.02.2022
 * Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
