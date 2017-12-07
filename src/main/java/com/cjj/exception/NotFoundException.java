package com.cjj.exception;

public class NotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super("对象未找到");
	}
	public NotFoundException(String msg) {
		super(msg);
	}
	
	public NotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
