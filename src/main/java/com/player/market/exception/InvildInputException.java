package com.player.market.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvildInputException extends RuntimeException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvildInputException(String exception) {
        super(exception);
    }
}