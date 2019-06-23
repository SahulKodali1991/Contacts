package dev.mongodb.contacts.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964644000543262400L;

	private String apiHealthResponse;

	public String getApiHealthResponse() {
		return apiHealthResponse;
	}

	public void setApiHealthResponse(String apiHealthResponse) {
		this.apiHealthResponse = apiHealthResponse;
	}

}
