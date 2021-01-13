package com.alvesjefs.msorders.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant timesTemp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timesTemp, Integer status, String error, String message, String path) {
		this.timesTemp = timesTemp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimesTemp() {
		return timesTemp;
	}

	public void setTimesTemp(Instant timesTemp) {
		this.timesTemp = timesTemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
