package com.example.crud.validator;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.crud.domain.Domain;

import jakarta.validation.ConstraintViolation;


public class BookValidator implements Validator{
	
	@Autowired
	private jakarta.validation.Validator beanValidator;
	
	
	public Set<Validator> springValidators;	
	
	public BookValidator() {
		springValidators = new HashSet<Validator>();
	}
	
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}
	
	@Override
	public boolean supports(Class<?>clazz) {
		return Domain.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);

		for (ConstraintViolation<Object> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			errors.rejectValue(propertyPath, "", message);
			
			
		}
		for (Validator validator : springValidators) {
				validator.validate(target, errors);
		}		
	}	

}
