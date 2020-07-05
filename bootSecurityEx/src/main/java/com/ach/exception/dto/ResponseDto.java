package com.ach.exception.dto;

public class ResponseDto {

	private String message;
	
	public ResponseDto(String message) {
		this.message = message;
	}	

	public static ResponseDto of(String message) {
		 return new ResponseDto(message);
	}
	
    public String getMessage() {
        return message;
    }
}
