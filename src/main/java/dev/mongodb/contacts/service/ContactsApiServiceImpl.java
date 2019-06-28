package dev.mongodb.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mongodb.contacts.model.ApiResponse;
import dev.mongodb.contacts.model.ContactRequest;
import dev.mongodb.contacts.repository.MongoRepo;
import dev.mongodb.contacts.utils.Constants;

@Service
public class ContactsApiServiceImpl implements ContactsApiService {

	@Autowired
	ApiResponse apiResponse;
	
	@Autowired
	MongoRepo repository;

	@Override
	public ApiResponse getAPiHealth() {
		apiResponse.setApiHealthResponse("Service is Healthy up and Running");
		return apiResponse;
	}

	@Override
	public ApiResponse addContact(ContactRequest contact) {
		int responseRecieved = repository.addContact(contact);
		if(responseRecieved == Constants.SUCCESS) {
			apiResponse.wasTransactionSuccessfull("true");	
		}else if(responseRecieved == Constants.USEREXISTS) {
			apiResponse.doesUserExistsAlready("true");
		}else if(responseRecieved == Constants.FAIL) {
			apiResponse.wasTransactionSuccessfull("false");
		}
		return apiResponse;
	}

}
