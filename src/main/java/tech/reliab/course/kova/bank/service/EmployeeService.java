package tech.reliab.course.kova.bank.service;

import tech.reliab.course.kova.bank.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
