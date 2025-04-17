package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.crud.domain.Domain;
import com.example.crud.servlet.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookservice;
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String requestBookList(Model model) {
		List<Domain> list = bookservice.getAllBookList();
		model.addAttribute("bookList", list);
		
		return "books";
	}
}
