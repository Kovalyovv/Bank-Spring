package tech.reliab.course.kova.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.kova.bank.entity.Employee;
import tech.reliab.course.kova.bank.repository.EmployeeRepository;
import tech.reliab.course.kova.bank.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        if (employee == null) {
            return null;
        }

        if (employee.getSalary() < 0) {
            System.err.println("[ERROR] | Employee -> salary must be non-negative");
            return null;
        }

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
