package com.interview.exception;

public class ConnectedAppException extends Exception {
	
	/**
	 * ConnectedAppException
	 */
	public ConnectedAppException() {
		super();
	}

	/**
	 * ConnectedAppException
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConnectedAppException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * ConnectedAppException
	 * @param message
	 * @param cause
	 */
	public ConnectedAppException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * ConnectedAppException
	 * @param message
	 */
	public ConnectedAppException(String message) {
		super(message);
	}

	/**
	 * ConnectedAppException
	 * @param cause
	 */
	public ConnectedAppException(Throwable cause) {
		super(cause);
	}

}
