package com.projet.library.controllers;

// import java.net.URI;
// import java.rmi.ServerException;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projet.library.entities.BookEntity;
import com.projet.library.repositories.BookRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

    @Autowired
	private BookRepository bookRepository;

	@GetMapping("getAllBooks")
	public ResponseEntity<Collection<BookEntity>> getAllBooks() {
		return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
	}

    // @PostMapping("utilisateurs/creation")
	// public ResponseEntity<BookEntity>createBook(@RequestBody BookEntity newBook) throws ServerException{
		
	// 	BookEntity book = bookRepository.save(newBook);
	// 	if(book==null) {
	// 		throw new ServerException("erreur du serveur");
	// 	} else {
	// 		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
	// 		return ResponseEntity.created(url).build();
	// 		//return new ResponseEntity<Noms>(utilisateur,HttpStatus.CREATED);
	// 	}
	// }
    
    //Method pour récupérer tous les livres

    //Method pour récupérer les livres par rapport à l'auteur
}
