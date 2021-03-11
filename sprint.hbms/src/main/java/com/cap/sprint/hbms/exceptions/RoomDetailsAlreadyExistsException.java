package com.cap.sprint.hbms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT)
public class RoomDetailsAlreadyExistsException extends RuntimeException {
	public RoomDetailsAlreadyExistsException() {
		super();
		
	} 
	

	public RoomDetailsAlreadyExistsException(String msg) {
		super(msg);		
		
	}
	
}
