package com.example.crud.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.crud.domain.Domain;

public interface BookRepository {
	List<Domain> getAllBookList();
	Domain getBookById(String bookId);
	void setNewBook(Domain book);
	List<Domain> getBookListByCategory(String category);
	Set<Domain> getBookListByFilter(Map<String, List<String>> filter);


}
