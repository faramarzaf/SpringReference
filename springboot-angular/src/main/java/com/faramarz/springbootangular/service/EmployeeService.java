package com.faramarz.springbootangular.service;


import com.faramarz.springbootangular.exception.ApiRequestException;
import com.faramarz.springbootangular.exception.newversion.ResourceNotFoundException;
import com.faramarz.springbootangular.model.Employee;
import com.faramarz.springbootangular.repo.EmployeeRepo;
import com.faramarz.springbootangular.repo.EmployeeRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeRepo2 employeeRepo2;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo,EmployeeRepo2 employeeRepo2) {
        this.employeeRepo = employeeRepo;
        this.employeeRepo2 = employeeRepo2;
    }


    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee.setName(employee.getName().trim());
        return employeeRepo.save(employee);

    }


    public List<Employee> addEmployees(Iterable<Employee> entities) {
        List<Employee> result = new ArrayList<>();
        if (entities == null) {
            return result;
        }
        for (Employee entity : entities) {
            entity.setEmployeeCode(UUID.randomUUID().toString());
            result.add(employeeRepo.save(entity));
        }
        return result;
    }


    public List<Employee> finAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Employee> pagedResult = employeeRepo2.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findByEmail(String email) {
        return employeeRepo.findByEmail(email);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new ResourceNotFoundException("User by id " + id + " was not found!"));
    }

    public Employee findEmployeeByEmployeeCode(String id) {
        return employeeRepo.findEmployeeByEmployeeCode(id).orElseThrow(() -> new ApiRequestException("User by employee-code " + id + " was not found!"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public void deleteAllEmployees() {
        employeeRepo.deleteAll();

    }

}
