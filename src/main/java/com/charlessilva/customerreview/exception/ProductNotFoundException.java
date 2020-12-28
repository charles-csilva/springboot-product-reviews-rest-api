package com.charlessilva.customerreview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException
{
	/**
	 *
	 */
	private static final long serialVersionUID = 6307154044006960176L;

	public ProductNotFoundException(final Long productId)
	{
		super("Product " + productId + " not found!");
	}
}
