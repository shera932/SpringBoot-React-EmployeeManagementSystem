package net.origins.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.origins.ems_backend.dto.EmployeeDto;
import net.origins.ems_backend.entity.Employee;
import net.origins.ems_backend.exception.ResourceNotFoundException;
import net.origins.ems_backend.mapper.EmployeeMapper;
import net.origins.ems_backend.repository.EmployeeRepository;
import net.origins.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a service component for Spring
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    // Repository for database operations
    private EmployeeRepository employeeRepository;

    // Creates a new employee record
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); // Convert DTO to Entity
        Employee savedEmployee = employeeRepository.save(employee); // Save Entity to the database
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); // Convert saved Entity back to DTO
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployees(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
