package com.faramarz.springbootangular.repo;


import com.faramarz.springbootangular.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface EmployeeRepo2 extends PagingAndSortingRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    Optional<Employee> findEmployeeByEmployeeCode(String id);

    Employee findByEmail(String email);

}
