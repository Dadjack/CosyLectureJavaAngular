package com.projet.library.controllers;

import com.projet.library.entities.BookEntity;
import com.projet.library.entities.CategoryEntity;
import com.projet.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {
    @Autowired
     CategoryRepository categoryRepository;

    @GetMapping("getAllCategories")
    public ResponseEntity<Collection<CategoryEntity>> getAllBooks() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
}
