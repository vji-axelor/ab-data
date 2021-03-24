package com.ab.data.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ContactApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();  
	   
    public ContactApplication() {  
        singletons.add(new ContactService(null));
    }  
   
    @Override 
    public Set<Object> getSingletons() {  
        return singletons;  
    }  

}
