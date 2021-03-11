package com.cap.sprint.hbms.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoRoomsListedException extends RuntimeException {
	Logger logger = LogManager.getLogger(NoRoomsListedException.class);
	public NoRoomsListedException(String msg) {
		super(msg);
//		System.out.println(msg);
		logger.fatal(msg);
	}
}
