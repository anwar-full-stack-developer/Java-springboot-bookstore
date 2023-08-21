package com.anwar.bookapp.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anwar.bookapp.model.Book;
import com.anwar.bookapp.service.BookServices;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	@Autowired
	private BookServices bookServices;

	
	// build create book REST API
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookServices.saveBook(book), HttpStatus.CREATED);
	}
	
	// build get all books REST API
	@GetMapping
	public List<Book> getAllBooks(){
		return bookServices.getAllBooks();
	}
	
	// build get book by id REST API
	// http://localhost:8080/api/books/1
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long bookId){
		return new ResponseEntity<Book>(bookServices.readBook(bookId), HttpStatus.OK);
	}
	
	// build update book REST API
	// http://localhost:8080/api/books/1
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") long id
												  ,@RequestBody Book book){
		return new ResponseEntity<Book>(bookServices.updateBook(book, id), HttpStatus.OK);
	}
	
	// build delete book REST API
	// http://localhost:8080/api/books/1
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable("id") long id){
		// delete book from DB
		bookServices.deleteBook(id);
		Map<String, Object> object = new HashMap<>();
		object.put("msg", "Data has been deleted succesfully!");
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
	
}