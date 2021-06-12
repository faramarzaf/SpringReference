package com.database.DatebaseRelations.manytomany.repository;


import com.database.DatebaseRelations.manytomany.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
