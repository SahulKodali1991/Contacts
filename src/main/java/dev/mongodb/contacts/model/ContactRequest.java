package dev.mongodb.contacts.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class ContactRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8261757592550948487L;
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
