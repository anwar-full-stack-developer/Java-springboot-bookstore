package com.anwar.bookapp.service;

import java.util.List;

import com.anwar.bookapp.model.Book;

public interface BookServices {
	
	Book saveBook(Book book);
	List<Book> getAllBooks();
	Book readBook(long id);
	Book updateBook(Book book, long id);
	void deleteBook(long id);
}