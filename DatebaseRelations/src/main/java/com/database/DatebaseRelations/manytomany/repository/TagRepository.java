package com.database.DatebaseRelations.manytomany.repository;


import com.database.DatebaseRelations.manytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
