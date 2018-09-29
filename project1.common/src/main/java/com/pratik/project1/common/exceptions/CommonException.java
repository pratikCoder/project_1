package com.pratik.project1.common.exceptions;

import com.pratik.project1.common.constants.ErrorMessages;

@SuppressWarnings("serial")
public class CommonException extends Exception {
	private String errorCode;
	private String errorMessage;

	// constructors
	public CommonException(ErrorMessages errorMessages) {
		super();
		this.errorCode = errorMessages.getErrorCode();
		this.errorMessage = errorMessages.getErrorMsg();
	}

	public CommonException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public CommonException(String errorMessage) {
		super(errorMessage);
	}

	// methodes
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CommonException getError() {
		return this;
	}
}
