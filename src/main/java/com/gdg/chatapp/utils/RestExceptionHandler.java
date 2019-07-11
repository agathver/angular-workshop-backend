package com.gdg.chatapp.utils;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gdg.chatapp.security.AccountAlreadyExistsException;
import com.gdg.chatapp.security.UserService;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	/**
	 * Method is called when an AccountAlreadyExistsException is thrown from the
	 * {@link UserService} registerUser(String name,String phone, String password)
	 * is called.i.e If the phone number provided as parameter for registration
	 * already exists as a user in system.
	 * 
	 * @param ex      Handles the {@link AccountAlreadyExistsException}
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */ 
	protected ResponseEntity<Object> handleAccountAlreadyExistsException(AccountAlreadyExistsException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, error, ex));
	}

}
