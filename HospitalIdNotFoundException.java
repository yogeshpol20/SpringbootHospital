package com.jsp.springboothospital.exception;

import lombok.Getter;

@Getter
public class HospitalIdNotFoundException extends RuntimeException
{
	private String message;
	
	public HospitalIdNotFoundException(String message)
	{
		super();
		this.message=message;
	}
}
