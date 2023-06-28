package com.product.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.service.response.dto.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler<T> {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<T> handelResourceNotFoundException(ResourceNotFoundException exception) {
		return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(exception.getMessage(), false, HttpStatus.NOT_FOUND, 404));
	}
	
}
