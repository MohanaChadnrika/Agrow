package com.jsp.Agro.dao.exception;

public class EmailDoesNotExist extends RuntimeException {
	private String msg = "";

	public String getMsg() {
		return msg;
	}

	public EmailDoesNotExist(String msg) {
		super();
		this.msg = msg;
	}

	public EmailDoesNotExist() {
		super();
	}

}
