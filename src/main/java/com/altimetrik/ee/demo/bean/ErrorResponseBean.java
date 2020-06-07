package com.altimetrik.ee.demo.bean;

public class ErrorResponseBean {

	private int errorCode;

	private String errorMessage;

	public ErrorResponseBean(int pErrorCode, String pErrorMessage) {
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