package com.database.DatebaseRelations.manytomany;

import com.database.DatebaseRelations.manytomany.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManyToManyController {


    @Autowired
    private ManyToManyService service;


    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = service.finAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article newArticle = service.addArticle(article);
        return new ResponseEntity<>(newArticle, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllArticles() {
        service.deleteAllArticles();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Post method sample
     * {
     *
     * 	"title":"second post",
     * 	"description":"java EE",
     * 	"content":"hi this is content",
     *
     * 	"tags":[
     *
     *                {
     * 			"name":"java",
     * 				"articles":
     * 				[
     *                    {
     * 			 		"title":"second post",
     * 					"description":"java EE",
     * 					"content":"hi this is content"
     *                    },
     *                    {
     * 			 		"title":"third post",
     * 					"description":"java SE",
     * 					"content":"hi this is content"
     *                    }
     * 			 	]
     *        },
     *
     *        {
     * 			"name":"spring",
     * 				"articles": [
     *                    {
     * 			 		"title":"forth post",
     * 					"description":"spring boot",
     * 					"content":"hi this is content"
     *                    }
     * 			 	]
     *        }
     *
     * 		]
     * }
     */









}
