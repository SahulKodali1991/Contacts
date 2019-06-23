package dev.mongodb.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mongodb.contacts.model.ApiResponse;

@Service
public class ContactsApiServiceImpl implements ContactsApiService {

	@Autowired
	ApiResponse apiHealthResponse;

	@Override
	public ApiResponse getAPiHealth() {
		apiHealthResponse.setApiHealthResponse("Service is Healthy up and Running");
		return apiHealthResponse;
	}

}
