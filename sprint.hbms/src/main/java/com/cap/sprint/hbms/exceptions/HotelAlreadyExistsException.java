package com.cap.sprint.hbms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class HotelAlreadyExistsException extends RuntimeException
	{
		public HotelAlreadyExistsException() {
			super();
			
		} 
		

		public HotelAlreadyExistsException(String msg) {
			super(msg);
			
		}

	}

