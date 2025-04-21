package com.example.crud.repository;

import java.util.List;

import com.example.crud.domain.Domain;

public interface BookRepository {
	List<Domain> getAllBookList();
	Domain getBookById(String bookId);

}
