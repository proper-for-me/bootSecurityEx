package com.ach.exception.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ach.exception.caseBy.JsonException;
import com.ach.exception.dto.ResponseDto;
import com.ach.login.dto.Member;

@RestController
public class ExceptionController {

	 @PostMapping("/jsonException")
	    public ResponseDto test(@RequestBody Member member){

	        String name = (String) Optional.ofNullable(member.getMbrName())
	                .orElseThrow( () -> new JsonException("Null Point Exception!!") );

	        return ResponseDto.of(name);
	    }

}
