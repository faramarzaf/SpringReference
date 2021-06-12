package com.faramarz.springbootangular.repo;


import com.faramarz.springbootangular.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    Optional<Employee> findEmployeeByEmployeeCode(String id);

    Employee findByEmail(String email);

}
