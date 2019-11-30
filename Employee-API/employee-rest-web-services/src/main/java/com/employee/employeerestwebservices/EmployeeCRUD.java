package com.employee.employeerestwebservices;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeCRUD extends Repository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);
}
