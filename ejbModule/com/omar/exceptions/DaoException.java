package com.omar.exceptions;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception mainException;

	public DaoException(Exception mainException) {
		this.mainException = mainException;
	}

	@Override
	public String getMessage() {
		return "DAO Exception || " + mainException.getMessage() + " || Inside DAO";
	}
}
