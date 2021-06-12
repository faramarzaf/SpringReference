package com.database.DatebaseRelations.onetoone.repository;

import com.database.DatebaseRelations.onetoone.entity.Userprofile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserprofileRepository extends JpaRepository<Userprofile, Long> {
}
