package com.todo.exceptions;

public class BaseException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public BaseException(String msg) {
		super(msg);
	}
}
