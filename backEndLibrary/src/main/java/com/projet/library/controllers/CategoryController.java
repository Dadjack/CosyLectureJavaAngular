package com.projet.library.controllers;

import com.projet.library.entities.CategoryEntity;
import com.projet.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import java.net.URI;
// import java.rmi.ServerException;
import java.util.Collection;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("getAllCategories")
    public ResponseEntity<Collection<CategoryEntity>> getAllBooks() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

    //      @PostMapping("admin/createBook")
	//  public ResponseEntity<BookEntity>createBook(@RequestBody BookEntity newBook) throws ServerException {
	//  	BookEntity book = bookRepository.save(newBook);
	//  	if(book==null) {
	//  		throw new ServerException("erreur du serveur");
	//  	} else {
	//  		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
	//  		return ResponseEntity.created(url).build();
	//  	}
	//  }
}
