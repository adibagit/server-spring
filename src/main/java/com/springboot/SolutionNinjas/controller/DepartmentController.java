package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Department;
import com.springboot.SolutionNinjas.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getDepartments() {
        return new ResponseEntity<List<Department>>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable int id) {
        return new ResponseEntity<Department>(departmentService.getOneDepartment(id),HttpStatus.OK);
    }

    @DeleteMapping("/department")
    public String deleteDepartment(@RequestParam int id) {
        departmentService.deleteDepartment(id);
        return "Department having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/department")
    public ResponseEntity<Department> insertDepartment(@Valid @RequestBody Department dept) {
        return new ResponseEntity<Department>(departmentService.insertDepartment(dept),HttpStatus.CREATED);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id,@RequestBody Department dept ) {
        dept.setDeptid(id);
        return new ResponseEntity<Department>(departmentService.updateDepartment(dept),HttpStatus.OK);
    }

    @GetMapping("/departments/withoutManager")
    public ResponseEntity<List<Department>> getDepartmentWithNoManager() {
        return new ResponseEntity<List<Department>>(departmentService.getDepartmentsWithoutManager(), HttpStatus.OK);
    }
    @GetMapping("/getDeparmentByEmployee/{userId}")
    public int getDepartmentOfEmp(@PathVariable int userId) {
        return departmentService.getDeptByEmpId(userId);
    }
}
