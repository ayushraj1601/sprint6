package com.cg.ibs.rm.model;

import java.io.Serializable;

public class BankRepresentative implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3690871004696421591L;
	private String response;

	public BankRepresentative() {
		super();
	}

	public BankRepresentative(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
