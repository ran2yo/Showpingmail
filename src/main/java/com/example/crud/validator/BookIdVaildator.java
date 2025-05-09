package com.example.crud.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.domain.Domain;
import com.example.crud.servlet.BookService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookIdVaildator implements ConstraintValidator<BookId, String>{
	 @Autowired
	 private BookService bookServicel;
	 
	@Override
	 public void initialize(BookId constraintAnnotation) {
		 ConstraintValidator.super.initialize(constraintAnnotation);
	 }
	 
	 


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Domain book;
		 try {
			book = bookServicel.getBookById(value);
		} catch (RuntimeException e) {
			// TODO: handle exception
			return true;
		}
		 if(book!=null) {
			 return false;
		 }
		 
		 return true;
		
	}
	

}
