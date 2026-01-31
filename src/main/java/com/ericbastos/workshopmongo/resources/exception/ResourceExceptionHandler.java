package com.ericbastos.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ericbastos.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_FOUND;
    String msg = "não encontrado";
    StandardError err = new StandardError(System.currentTimeMillis(),status.value(),msg,e.getMessage(),request.getRequestURI());
    return ResponseEntity.status(status).body(err);
	}
}
