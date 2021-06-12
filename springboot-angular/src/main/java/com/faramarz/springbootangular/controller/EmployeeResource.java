package com.faramarz.springbootangular.controller;


import com.faramarz.springbootangular.model.Employee;
import com.faramarz.springbootangular.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {


    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/employee/all2?pageSize=20&pageNo=0&sortBy=id, pageSize=10---> returns 10 employee
    @GetMapping("/all2")
    public ResponseEntity<List<Employee>> getAllEmployees2(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.finAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) {
        Employee employee = employeeService.findByEmail(email);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/findByEmployeeCode/{id}")
    public ResponseEntity<Employee> getEmployeeByEmployeeCode(@PathVariable("id") String id) {
        Employee employee = employeeService.findEmployeeByEmployeeCode(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/addAll")
    public ResponseEntity<?> addEmployees(@RequestBody @Valid List<Employee> employee) {
        List<Employee> newEmployee = employeeService.addEmployees(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
