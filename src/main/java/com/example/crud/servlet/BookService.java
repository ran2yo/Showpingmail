package com.example.crud.servlet;

import java.util.List;

import com.example.crud.domain.Domain;

public interface BookService {
	List<Domain> getAllBookList();
	Domain getBookById(String bookId);
}
