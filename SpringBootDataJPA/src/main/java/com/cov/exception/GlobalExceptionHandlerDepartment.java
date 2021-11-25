package com.cov.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerDepartment {
	Logger logger = Logger.getLogger(GlobalExceptionHandlerDepartment.class);

	public ResponseEntity<String> aaa(InvalidDepartmentIdException invalidDepartmentIdException) {
		String errorResponse = invalidDepartmentIdException.getMessage();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidDepartmentIdException.class)
	public ResponseEntity<ErrorResponse> invalidDepartmentIdHandler(
			InvalidDepartmentIdException invalidDepartmentIdException) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = invalidDepartmentIdException.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		logger.info("status" + status);
		logger.info("message" + message);
		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> otherHandler(Exception exception) {
		String message = exception.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}