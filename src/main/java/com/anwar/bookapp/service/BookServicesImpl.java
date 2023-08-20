package com.anwar.bookapp.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.anwar.bookapp.exception.ResourceNotFoundException;
import com.anwar.bookapp.model.Book;
import com.anwar.bookapp.repository.BookRepository;


@Service
public class BookServicesImpl implements BookServices{
	@Autowired
	private BookRepository bookRepository;
	

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return  (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book readBook(long id) {
//		Optional<Book> book = bookRepository.findById(id);
//		if(employee.isPresent()) {
//			return book.get();
//		}else {
//			throw new ResourceNotFoundException("Book", "Id", id);
//		}
		return bookRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Book", "Id", id));
	}

	@Override
	public Book updateBook(Book book, long id) {
		// we need to check whether book with given id is exist in DB or not
//		Book existingbook = bookRepository.findById(id).get();
		Book existingbook = bookRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Book", "Id", id));
		
		existingbook.setName(book.getName());
		existingbook.setPrice(book.getPrice());
		existingbook.setDescription(book.getDescription());
		// save existing employee to DB
		return bookRepository.save(existingbook);
	}

	@Override
	public void deleteBook(long id) {
		
		// check whether a book exist in a DB or not
		bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", id));
		bookRepository.deleteById(id);

		
	}
	
}