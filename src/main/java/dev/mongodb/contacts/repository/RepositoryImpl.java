package dev.mongodb.contacts.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dev.mongodb.contacts.model.ContactRequest;
import dev.mongodb.contacts.utils.Constants;

@Repository
public class RepositoryImpl implements MongoRepo{
	
	private static final Log log =  LogFactory.getLog(RepositoryImpl.class);
	
	Document document = new Document();
	
	@Value("${mongodbhost}")
	private String host;
	
	@Value("${mongodbport}")
	private int port;
	
	@Value("${mongodatabase}")
	private String dbName;
	
	@Value("${collection}")
	private String collectionName;

	@Override
	public int addContact(ContactRequest contact) {
		MongoClientURI connectionUrl = new MongoClientURI(buildURL().toString());
		MongoClient client = new MongoClient(connectionUrl);
		try {
			MongoDatabase db = client.getDatabase(dbName);
			MongoCollection<Document> collection = db.getCollection(collectionName);
			if(collection.find(Filters.eq(Constants.PHONENUMBER, contact.getPhoneNumber())).iterator().hasNext()) {
				log.info("user already exists with this contact number :: "+ contact.getPhoneNumber());
				return Constants.USEREXISTS;
			}else {
				document.put(Constants.FIRSTNAME,contact.getFirstName());
				document.put(Constants.LASTNAME,contact.getLastName());
				document.put(Constants.PHONENUMBER,contact.getPhoneNumber());
				collection.insertOne(document);
				return Constants.SUCCESS;
			}
		}catch (MongoWriteException exception) {
			exception.printStackTrace();
			return Constants.FAIL;
		}finally {
			client.close();
		}
		
	}
	
	private StringBuffer buildURL() {
		StringBuffer url = new StringBuffer();
		url.append("mongodb://"+host+":"+port+"/"+dbName); 
		return url;
	}

}
