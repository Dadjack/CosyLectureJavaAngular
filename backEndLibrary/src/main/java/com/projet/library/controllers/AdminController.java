package com.projet.library.controllers;

import java.net.URI;
import java.rmi.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.library.entities.BookEntity;
import com.projet.library.entities.CategoryEntity;
import com.projet.library.repositories.BookRepository;
import com.projet.library.repositories.CategoryRepository;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @Autowired
	private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("createBook")
	public ResponseEntity<BookEntity>createBook(@RequestBody BookEntity newBook) throws ServerException {
		BookEntity book = bookRepository.save(newBook);
		if(book==null) {
			throw new ServerException("erreur du serveur");
		} else {
			URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
			return ResponseEntity.created(url).build();
		}
	}

    @PostMapping("admin/createCategory")
	public ResponseEntity<CategoryEntity>createCategory(@RequestBody CategoryEntity newCategory) throws ServerException {
        CategoryEntity category = categoryRepository.save(newCategory);
        if(category==null) {
            throw new ServerException("erreur du serveur");
        } else {
            URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
            return ResponseEntity.created(url).build();
        }
	}
}
