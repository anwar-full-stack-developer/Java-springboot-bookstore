package com.anwar.bookapp.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anwar.bookapp.model.Book;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// Annotation
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


}
