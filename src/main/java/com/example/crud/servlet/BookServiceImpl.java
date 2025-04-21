package com.example.crud.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.domain.Domain;
import com.example.crud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	public List<Domain> getAllBookList(){
	
		
		
		return bookRepository.getAllBookList();
	}

	
	public Domain getBookById(String bookId) {
		Domain bookById = bookRepository.getBookById(bookId);
		
		return bookById;
	}
}
