package es.kairos.productomicroservicio.handler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleConflictNoSuchElement(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<Object> handleConflictBadRequest(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, "", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
