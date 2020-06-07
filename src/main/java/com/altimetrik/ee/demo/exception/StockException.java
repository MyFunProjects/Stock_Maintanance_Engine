package com.altimetrik.ee.demo.exception;

public class StockException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;

	private String errorMessage;

	public StockException(int pErrorCode, String pErrorMessage) {
		this.errorCode = pErrorCode;
		this.errorMessage = pErrorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
