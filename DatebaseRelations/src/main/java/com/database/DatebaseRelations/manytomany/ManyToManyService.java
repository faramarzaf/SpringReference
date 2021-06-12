package com.database.DatebaseRelations.manytomany;

import com.database.DatebaseRelations.manytomany.entity.Article;
import com.database.DatebaseRelations.manytomany.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyService {

    @Autowired
    ArticleRepository articleRepository;

    public Article addArticle(Article article){
        return articleRepository.save(article);
    }

    public List<Article> finAllArticles() {
        return articleRepository.findAll();
    }

    public void deleteAllArticles() {
        articleRepository.deleteAll();

    }

}
