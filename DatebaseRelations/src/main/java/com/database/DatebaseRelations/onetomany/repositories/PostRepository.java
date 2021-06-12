package com.database.DatebaseRelations.onetomany.repositories;

import com.database.DatebaseRelations.onetomany.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post ,Long> {
}
