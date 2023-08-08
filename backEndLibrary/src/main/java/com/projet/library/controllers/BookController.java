package com.projet.library.controllers;

// import java.net.URI;
// import java.rmi.ServerException;

import java.net.URI;
import java.rmi.ServerException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projet.library.entities.BookEntity;
import com.projet.library.repositories.BookRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

    @Autowired
	private BookRepository bookRepository;

	@GetMapping("getAllBooks")
	public ResponseEntity<Collection<BookEntity>> getAllBooks() {
		return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
	}

     @PostMapping("admin/createBook")
	 public ResponseEntity<BookEntity>createBook(@RequestBody BookEntity newBook) throws ServerException {
	 	BookEntity book = bookRepository.save(newBook);
	 	if(book==null) {
	 		throw new ServerException("erreur du serveur");
	 	} else {
	 		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
	 		return ResponseEntity.created(url).build();
	 	}
	 }
    
    //Method pour récupérer tous les livres

    //Method pour récupérer les livres par rapport à l'auteur
}
