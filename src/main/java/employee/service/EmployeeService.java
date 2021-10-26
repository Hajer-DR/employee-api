package employee.service;

import employee.exception.ResourceNotFoundException;
import employee.model.Employee;
import employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long employeeId) throws ResourceNotFoundException {

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
