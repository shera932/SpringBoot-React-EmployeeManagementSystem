package net.origins.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.origins.ems_backend.dto.EmployeeDto;
import net.origins.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
// Marks this class as a REST controller for Spring
@RestController
// Maps HTTP requests to /api/employees to this controller
@RequestMapping("/api/employees")
public class EmployeeController {

    // Service to handle employee-related operations
    private EmployeeService employeeService;

    // Method to add a new employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        // Calls the service to create a new employee
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        // Returns the created employee and a 201 status (Created)
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Buid Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto);
    }
    //Build Get All Employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);

    }
    //Build to update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmloyee(@PathVariable("id") Long employeeId ,
                                                     @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployees(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);

    }
    //Build to delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(("Employee Deleted Sucessfully!"));
    }
}
