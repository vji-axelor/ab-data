package com.ab.data.service;

import java.util.List;

import com.ab.data.pojo.Contect;

public interface ContectService {
	
	boolean addContect(String firstName, String lastName, String zipcode, String email,String street);

	void deleteContect(int id);

	void show();

	Contect getSingleContect(int id);
	
	List<Contect> getContectList();
	
	void updateContect(String firstName, String lastName, String zipcode, String email,String street, int id);
}
