package com.projet.library.controllers;

// import java.net.URI;
// import java.rmi.ServerException;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.library.entities.BookEntity;
import com.projet.library.repositories.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
	private BookRepository bookRepository;

	@GetMapping("getAllBooks")
	public ResponseEntity<Collection<BookEntity>> getAllBooks() {
		return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
	}
    
    //Method pour récupérer tous les livres

    //Method pour récupérer les livres par rapport à l'auteur
}
