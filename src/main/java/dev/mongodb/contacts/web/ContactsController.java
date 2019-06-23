package dev.mongodb.contacts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.mongodb.contacts.model.ApiResponse;
import dev.mongodb.contacts.service.ContactsApiService;

@Controller
@RequestMapping("contacts")
public class ContactsController {

	@Autowired
	ContactsApiService serviceResponse;
	
	@RequestMapping(value = "/apihealthcheck", method = RequestMethod.GET)
	@ResponseBody
	private ApiResponse checkApiHealth() {
		return serviceResponse.getAPiHealth();
	}

}
