package com.shellproject.shellproject.responses;

import java.io.Serializable;

public class MobileResponse implements Serializable{
    private static final long serialVersionUID = -8091879091924046844L;
	private final String mobile;

	public MobileResponse(String mobile) {
		this.mobile = mobile;
	}

	public String getToken() {
		return this.mobile;
	}
}
