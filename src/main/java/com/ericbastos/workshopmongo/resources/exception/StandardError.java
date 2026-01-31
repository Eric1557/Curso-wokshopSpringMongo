package com.ericbastos.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long timesTamp;
	private Integer status;
	private String msg;
	private String error;
	private String path;
	
	
	public StandardError() {
	}


	public StandardError(Long timesTamp, Integer status, String msg, String error, String path) {
		super();
		this.timesTamp = timesTamp;
		this.status = status;
		this.msg = msg;
		this.error = error;
		this.path = path;
	}


	public Long getTimesTamp() {
		return timesTamp;
	}


	public void setTimesTamp(Long timesTamp) {
		this.timesTamp = timesTamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}	
	
}
