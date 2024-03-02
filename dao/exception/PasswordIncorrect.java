package com.jsp.Agro.dao.exception;

public class PasswordIncorrect extends RuntimeException {
	private String msg = "";

	public String getMsg() {
		return msg;
	}

	public PasswordIncorrect(String msg) {
		super();
		this.msg = msg;
	}

	public PasswordIncorrect() {
		super();
	}

}
