package com.medicare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resource;
	
	private String field;
	
	private String fieldValue;

	public ResourceNotFoundException(String resource, String field, String fieldValue) {
		super(String.format("%s not found with firld %s and value %s", resource,field,fieldValue));
		this.resource = resource;
		this.field = field;
		this.fieldValue = fieldValue;
	}

	public String getResource() {
		return resource;
	}

	public String getField() {
		return field;
	}

	public String getFieldValue() {
		return fieldValue;
	}
	
	



}
