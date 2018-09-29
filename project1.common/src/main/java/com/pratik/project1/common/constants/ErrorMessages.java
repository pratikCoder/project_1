package com.pratik.project1.common.constants;

public enum ErrorMessages {

	USER_DOES_NOT_EXISTS("error001", "User Does Not Exists"),
	INVALID_USERNAME_AND_PASSWORD("error002", "invalid Username And Password"),
	USER_IS_INAVCTIV("error003", "User is Inactive"),
	USER_EMAIL_INVALID("error004", "User Email is Invalid"),
	
	
	;
	
	private String errorCode;
	private String errorMsg;

	ErrorMessages(String errorCode, String errorMssg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMssg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
