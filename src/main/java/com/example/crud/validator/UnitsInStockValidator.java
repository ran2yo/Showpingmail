package com.example.crud.validator;

import java.util.Set;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.crud.domain.Domain;



@Component
public class UnitsInStockValidator implements Validator{
	
	public boolean supports(Class<?>clazz) {
		return Domain.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		Domain book = (Domain) target;
		if(book.getUnitPrice()!=null && book.getUnitPrice().intValue()>= 10000 && book.getUnitsInStock()>99){
			errors.rejectValue("unitsInStock", "UnitsInStockValidator.message", "가격이 1000 원 이상인 경우에는 99개 이상을 등록할 수 없습니다. ");
		}
		
	}

	
	

}
