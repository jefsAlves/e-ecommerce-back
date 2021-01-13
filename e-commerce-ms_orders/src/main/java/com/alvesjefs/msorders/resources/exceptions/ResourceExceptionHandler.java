package com.alvesjefs.msorders.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alvesjefs.msorders.services.exceptions.IdNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<StandardError> idNotFound(IdNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimesTemp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Sorry,Resource not Found!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
