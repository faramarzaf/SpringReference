package com.database.DatebaseRelations.onetoone.repository;

import com.database.DatebaseRelations.onetoone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
