package com.rest.handler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rest.exceptions.ActivityNotFoundException;
import com.rest.exceptions.DuplicateEntityException;
import com.rest.exceptions.InvalidUserException;
import com.rest.exceptions.LoginException;
import com.rest.exceptions.NoDataException;
import com.rest.exceptions.NotAuthorizedException;
import com.rest.exceptions.UserNotFoundException;
import org.postgresql.util.*;
@ControllerAdvice
public class AllExceptionshandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleInvalidEntity(MethodArgumentNotValidException me){
		
		List<String> messages=me.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x->x.getDefaultMessage())
				.collect(Collectors.toList());
		
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","Entity Error");
		errors.put("details",messages);
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFound(UserNotFoundException en){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","Not found Error");
		errors.put("details",en.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<?> handleUserDataErrors(InvalidUserException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<?> handleLoginError(LoginException ex){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","login Error");
		errors.put("details",ex.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ActivityNotFoundException.class)
	public ResponseEntity<?> handleActivityError(ActivityNotFoundException ex){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","invalid Activity Error");
		errors.put("details",ex.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<?> handleNoData(NoDataException de){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","no data Error");
		errors.put("details",de.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotAuthorizedException.class)
	public ResponseEntity<?> handleLoginerror(NotAuthorizedException de){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","Authorization error");
		errors.put("details",de.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DuplicateEntityException.class)
	public ResponseEntity<?> handleSameEntityError(DuplicateEntityException de){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","duplicate entity error");
		errors.put("details",de.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<?> handlePSQLError(PSQLException de){
		Map<String,Object> errors=new LinkedHashMap<>();
		errors.put("error","contraint voilation error");
		errors.put("details",de.getMessage());
		errors.put("timestamp",LocalDate.now());
		
		return new ResponseEntity<Map>(errors,HttpStatus.BAD_REQUEST);
	}
}
