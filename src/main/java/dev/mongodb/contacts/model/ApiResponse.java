package dev.mongodb.contacts.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@JsonInclude(Include.NON_NULL)
public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964644000543262400L;

	private String apiHealthResponse;
	private String wasTransactionSuccessfull;
	private String doesUserExistsAlready;

	
	public String getWasTransactionSuccessfull() {
		return wasTransactionSuccessfull;
	}

	public void wasTransactionSuccessfull(String wasTransactionSuccessfull) {
		this.wasTransactionSuccessfull = wasTransactionSuccessfull;
	}

	public String getDoesUserExistsAlready() {
		return doesUserExistsAlready;
	}

	public void doesUserExistsAlready(String doesUserExistsAlready) {
		this.doesUserExistsAlready = doesUserExistsAlready;
	}

	public String getApiHealthResponse() {
		return apiHealthResponse;
	}

	public void setApiHealthResponse(String apiHealthResponse) {
		this.apiHealthResponse = apiHealthResponse;
	}

}
