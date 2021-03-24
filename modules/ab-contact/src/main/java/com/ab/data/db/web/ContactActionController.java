
package com.ab.data.db.web;

import java.util.Map;

import com.ab.data.contact.db.Contact;
import com.ab.data.contact.db.repo.ContactRepository;
import com.axelor.meta.CallMethod;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;


public class ContactActionController {
	
	@Inject ContactRepository contactRepo;

	  @SuppressWarnings({"unchecked", "static-access"})
	  @CallMethod
	  @Transactional
	public void saveContactRecord(ActionRequest request, ActionResponse response) {
		 
		  Map<String, Object> obj = request.getData();
		  
		  Contact contact = new Contact();
		  
		  if(obj.get("email").toString() == null || obj.get("email").toString() == "") {
			  response.setValue("data", "Please enter emial Address");
			  return;
		  }
		  
		  String email =  obj.get("email").toString();
		  String sufix = email.substring(email.length() - 4 , email.length());
		  
		  
		  if(!sufix.equals(".com")){
			  response.setValue("data", "Please enter valid emial Address end with .com");
			  return;
		  }
		  
		  if(obj.get("zipcode") == null && obj.get("zipcode").toString().length() != 5) {
			  response.setValue("data", "Zipcode lenght should be five.");
			  return;
		  }
	
		  
		  contact.setEmail(obj.get("email").toString());
		  contact.setFirstName(obj.get("firstName").toString());
		  contact.setLastName(obj.get("lastName").toString());
		  contact.setStreet(obj.get("street").toString());
		  contact.setZipcode(obj.get("zipcode").toString());
		  
		  Contact record = contactRepo.save(contact);
		  response.setValue("data", record);		  
	}
}
