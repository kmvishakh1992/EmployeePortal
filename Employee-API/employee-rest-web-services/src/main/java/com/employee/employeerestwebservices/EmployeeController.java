package com.employee.employeerestwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="*")
@RestController
public class EmployeeController {

        @Autowired
        private EmployeeRepository repository;

        // Find
        @GetMapping("/employees")
        List<Employee> findAll() {
            List<Employee> sortedList = repository.findAll().stream()
                    .sorted((e1,e2)-> e1.getFirstName().compareTo(e2.getFirstName()))
                    .collect(Collectors.toList());
            return sortedList;
        }

        // Save
        @PostMapping("/employees")
        //return 201 instead of 200
        @ResponseStatus(HttpStatus.CREATED)
        Employee newBook(@RequestBody Employee newEmployee) {
            return repository.save(newEmployee);
        }

}
