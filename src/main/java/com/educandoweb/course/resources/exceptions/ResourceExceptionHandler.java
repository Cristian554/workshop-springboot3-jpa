package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Anotação que intercepta as excessões para tratar
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // Anotação para interceptar excessão
	 public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource  no found"; 
		HttpStatus status = HttpStatus.NOT_FOUND; 
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // Instanciando o StandarError
		return ResponseEntity.status(status).body(err);// Status que passa a mensagem ppersonalizada da excessão
	}
	
}
