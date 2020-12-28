package com.charlessilva.customerreview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{

	/**
	 *
	 */
	private static final long serialVersionUID = -4158303726287904684L;

	public UserNotFoundException(Long userId)
	{
		super("User " + userId + " not found!");
	}
}
