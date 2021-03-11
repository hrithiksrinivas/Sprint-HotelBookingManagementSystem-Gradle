package com.cap.sprint.hbms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class PaymentAlreadyExistsException extends RuntimeException
{
	public PaymentAlreadyExistsException()
	{
		super();
	}
	
	public PaymentAlreadyExistsException(String msg)
	{
		super(msg);
	}
	
}