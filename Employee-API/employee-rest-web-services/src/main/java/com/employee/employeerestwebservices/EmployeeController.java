package com.employee.employeerestwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

        @Autowired
        private EmployeeRepository repository;

        // Find
        @GetMapping("/employees")
        List<Employee> findAll() {
            return repository.findAll();
        }

        // Save
        @PostMapping("/employees")
        //return 201 instead of 200
        @ResponseStatus(HttpStatus.CREATED)
        Employee newBook(@RequestBody Employee newEmployee) {
            return repository.save(newEmployee);
        }

}
