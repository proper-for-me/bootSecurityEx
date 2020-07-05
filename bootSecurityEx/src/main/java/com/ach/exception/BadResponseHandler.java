package com.ach.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ach.exception.caseBy.JsonException;
import com.ach.exception.dto.ResponseDto;

@ControllerAdvice
public class BadResponseHandler {

	@ExceptionHandler(JsonException.class)
	public ResponseDto jsonException(JsonException ex) {
		return ResponseDto.of(ex.getMessage());
	}
}
