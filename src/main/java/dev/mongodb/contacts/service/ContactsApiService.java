package dev.mongodb.contacts.service;

import dev.mongodb.contacts.model.ApiResponse;
import dev.mongodb.contacts.model.ContactRequest;


public interface ContactsApiService {

	ApiResponse getAPiHealth();
	ApiResponse addContact(ContactRequest contact);
	
}

