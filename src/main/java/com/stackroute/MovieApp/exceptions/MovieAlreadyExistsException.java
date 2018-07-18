package com.stackroute.MovieApp.exceptions;

import org.apache.logging.log4j.message.Message;

public class MovieAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieAlreadyExistsException(String message ) {
		super(message);
	}

}
