package com.example.crud.controller;

import java.util.List;
import com.example.crud.servlet.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.domain.Domain;
import com.example.crud.servlet.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    
	@Autowired //클래스의 프로퍼티(멤버 변수 선언)
	private BookService bookservice;


	
	@GetMapping
	public String requestBookList(Model model) {
		List<Domain> list = bookservice.getAllBookList();
		model.addAttribute("bookList", list);
		
		return "books";
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBookList() {
		ModelAndView modelAndView = new ModelAndView();		
		List<Domain> list = bookservice.getAllBookList();
		modelAndView.addObject("bookList",list);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id")String bookId, Model model) {
		Domain bookById = bookservice.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
}
