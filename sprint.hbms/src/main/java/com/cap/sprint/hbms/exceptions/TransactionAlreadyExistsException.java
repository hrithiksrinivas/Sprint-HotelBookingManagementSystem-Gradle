package com.cap.sprint.hbms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class TransactionAlreadyExistsException extends RuntimeException
{
	public TransactionAlreadyExistsException() {
		super();
		
	} 
	

	public TransactionAlreadyExistsException(String msg) {
		super(msg);
		
	}

}