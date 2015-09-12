package demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler({ DuplicateKeyException.class })
	@ResponseStatus(HttpStatus.CONFLICT)
	public void serviceErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
	}
}
