package com.example.crud.servlet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.domain.Domain;
import com.example.crud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Domain> getAllBookList(){



		return bookRepository.getAllBookList();
	}


	@Override
	public Domain getBookById(String bookId) {
		Domain bookById = bookRepository.getBookById(bookId);

		return bookById;
	}

	@Override
	public void setNewBook(Domain book) {
		bookRepository.setNewBook(book);
	}

	@Override
	public List<Domain> getBookListByCategory(String category) {
		List<Domain> bookByCategory = bookRepository.getBookListByCategory(category);

		return bookByCategory;
	}



	@Override
	public Set<Domain> getBookListByFilter(Map<String, List<String>> filter) {
		Set<Domain> booksByFilter = bookRepository.getBookListByFilter(filter);

		return booksByFilter;
	}
}
