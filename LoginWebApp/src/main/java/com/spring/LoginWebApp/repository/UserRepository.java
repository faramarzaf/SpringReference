package com.spring.LoginWebApp.repository;

import com.spring.LoginWebApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsUserByEmail(String email);

}
