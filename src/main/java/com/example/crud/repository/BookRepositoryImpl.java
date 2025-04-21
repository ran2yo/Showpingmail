package com.example.crud.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.crud.domain.Domain;

@Repository
public class BookRepositoryImpl implements BookRepository {
	private List<Domain> listOfBooks = new ArrayList<>();
	
	public Domain getBookById(String bookId) {
		Domain bookInfo = null;
		for(int i =0; i<listOfBooks.size(); i++) {
			Domain book = listOfBooks.get(i);
			if(book!=null && book.getBookId()!=null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if(bookInfo == null) 
			throw new IllegalArgumentException("도서 ID가 " + bookId + "인 해당 도서를 찾을 수 없습니다.");
		
		return bookInfo;
	}

	public BookRepositoryImpl() {
		Domain book1 = new Domain();
		book1.setBookId("ISBN1234");
		book1.setName("입문");
		book1.setUnitPrice(new BigDecimal(1000));
		book1.setAuthor("ranyoung");
		book1.setDescription(
				"testing ~~1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,181,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,181,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18");
		book1.setPublisher("한및미디어");
		book1.setCategory("IT전문서");
		book1.setReleaseDate("2025/04/10");

		Domain book2 = new Domain();
		book2.setBookId("ISBN156968");
		book2.setName("개발자");
		book2.setUnitPrice(new BigDecimal(1000));
		book2.setAuthor("ranyoung");
		book2.setDescription(
				"testing ~~1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,181,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18");
		book2.setPublisher("스프링부트좀잘좀하자");
		book2.setCategory("IT전문서");
		book2.setReleaseDate("2025/06/10");

		Domain book3 = new Domain();
		book3.setBookId("ISBN14534");
		book3.setName("개발자");
		book3.setUnitPrice(new BigDecimal(1000));
		book3.setAuthor("ranyoung");
		book3.setDescription("testing ~~1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,14,15,16,17,18");
		book3.setPublisher("스프링부트좀잘좀하자");
		book3.setCategory("IT전문서");
		book3.setReleaseDate("2025/06/10");
		
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}


	public List<Domain> getAllBookList() {
		// TODO Auto-generated method stub
		return listOfBooks;
	}
	

}
