package com.jhecohe.ReservasAPI.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { ServiceException.class })
	protected ResponseEntity<Object> handleIssues(ServiceException se, WebRequest requess) {

		String bodyOfResponse = se.getMessage();
		return handleExceptionInternal(se, bodyOfResponse, new HttpHeaders(), se.getHttpStatus(), requess);
	}
}
