package com.jerry.frame.exception;

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5942817887720628652L;
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	private String errorCode;
	private String errorInfo;
	
	
public BusinessException(Throwable throwable){
	
	super(throwable);
	
}

public BusinessException(String message ,Throwable throwable){
	
	super(message,throwable);
	this.errorInfo = message;
}

public BusinessException(String errorCode,String errorInfo,Throwable throwable){
	super(errorCode+ ":" + errorInfo,throwable);
	this.errorCode = errorCode;
	this.errorInfo = errorInfo;
			
}


}
