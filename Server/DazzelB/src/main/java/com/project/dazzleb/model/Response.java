package com.project.dazzleb.model;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private int responseCode;
	private String responseMgs;
	private String data;
	private Object jData;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMgs() {
		return responseMgs;
	}

	public void setResponseMgs(String responseMgs) {
		this.responseMgs = responseMgs;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Object getjData() {
		return jData;
	}

	public void setjData(Object jData) {
		this.jData = jData;
	}

}
