package com.faramarz.spring.springbootfirst;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book(1, "spring book1", "sam")
                , new Book(2, "java book1", "john")
                , new Book(3, "php book1", "kali")
                , new Book(4, "python book1", "anson"));
    }

}
