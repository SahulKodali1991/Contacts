package dev.mongodb.contacts.repository;

import dev.mongodb.contacts.model.ContactRequest;

public interface MongoRepo {

	int addContact(ContactRequest contact);
}
