package com.cap.sprint.hbms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class BookingDetailsAlreadyExistsException extends RuntimeException {
	
	public BookingDetailsAlreadyExistsException() {
		super();
	}

	public BookingDetailsAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
