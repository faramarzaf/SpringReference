package com.faramarz.spring.startdatabase.newWay;


import com.faramarz.spring.startdatabase.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSpringDataRepository extends JpaRepository<Employee, Integer> {
    //Integer--> id is primary key and it's integer
}
