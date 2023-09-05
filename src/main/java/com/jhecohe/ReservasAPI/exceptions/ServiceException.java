package com.jhecohe.ReservasAPI.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	private HttpStatus httpStatus;
	
	public ServiceException(String message, HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}	
	
}
