package com.jsp.Agro.dao.exception;

public class EmailAlreadyRegistered extends RuntimeException {
	private String msg = "";

	public String getMsg() {
		return msg;
	}

	public EmailAlreadyRegistered(String msg) {
		super();
		this.msg = msg;
	}

	public EmailAlreadyRegistered() {
		super();
	}

}
