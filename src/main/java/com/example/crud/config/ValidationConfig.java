package com.example.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.crud.validator.BookValidator;
import com.example.crud.validator.UnitsInStockValidator;

@Configuration
public class ValidationConfig {
	
	@Autowired
	UnitsInStockValidator unitsInStockValidator;
	
	@Bean
	public BookValidator bookValidator() {
		BookValidator bookValidator = new BookValidator();
		bookValidator.springValidators.add(unitsInStockValidator);
		return bookValidator;
	}
}
