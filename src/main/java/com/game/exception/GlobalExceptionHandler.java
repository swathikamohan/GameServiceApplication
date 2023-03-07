package com.game.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ValueNotFoundException.class)
	public ResponseEntity<String> valueNotFound(ValueNotFoundException e) {
		return new ResponseEntity<>("Value Not Found", HttpStatus.NOT_FOUND);
	}	

	@ExceptionHandler(value = GameAlreadyExistsException.class)
	public ResponseEntity<String> gameAlreadyExists(GameAlreadyExistsException e) {
		return new ResponseEntity<>("Game Already Exists", HttpStatus.FOUND);
	}

}


























































