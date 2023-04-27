package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Employee;
import com.springboot.SolutionNinjas.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployee(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        return new ResponseEntity<Employee>(employeeService.getOneEmployee(id),HttpStatus.OK);
    }

    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "Employee having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> insertEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.insertEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee ) {
        employee.setEmpid(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK);
    }
}
