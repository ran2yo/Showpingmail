package com.example.crud.domain;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.example.crud.validator.BookId;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Domain {
	@BookId
	@Pattern(regexp = "ISBN[1-9]+", message = "{Pattern.book.bookId}")
	private String bookId; // 도서ID

	@Size(min = 4, max = 50, message = "{Size.book.name}")
	private String name; // 도서명

	@Min(value = 0, message = "{Min.book.unitPrice}")
	@Digits(integer = 8, fraction = 2, message = "{Digits.book.unitPrice}")
	@NotNull(message = "{NotNull.book.unitPrice}")
	private BigDecimal unitPrice; // 가격
	private String author; // 저자
	private String description; // 설명
	private String publisher; // 출판사
	private String category; // 분류
	private long unitsInStock; // 재고수
	private String releaseDate; // 출판일
	private String condition; // 상태 : 신규도서/E-Book/중고도서
	private String fileName; // 도서 이미지 파일
	private MultipartFile bookImage; // 도서 이미지

}
