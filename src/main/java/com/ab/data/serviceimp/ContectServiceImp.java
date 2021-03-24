package com.ab.data.serviceimp;

import java.util.List;

import com.ab.data.pojo.Contect;
import com.ab.data.service.ContectDao;
import com.ab.data.service.ContectService;
import com.google.inject.Inject;

public class ContectServiceImp implements ContectService {

	
	ContectDao contectDao = null;
	
	@Inject
	ContectServiceImp(ContectDao contectDao) {
		this.contectDao = contectDao;
	}
	
	
	public ContectServiceImp() {
		super();
	}


	@Override
	public boolean addContect(String firstName, String lastName, String zipcode, String email,String street) {
		System.out.println("working.....");
		boolean ans = contectDao.addContect(firstName, lastName, zipcode, email,street);

		return ans;
	}

	public List<Contect> getContectList() {
		List<Contect> list = ((ContectServiceImp) contectDao).getContectList();
		return list;
	}

	@Override
	public void deleteContect(int id) {
		contectDao.deleteContect(id);
		
		
	}
	
	@Override
	public Contect getSingleContect(int id) {
		return contectDao.getSingleContect(id);
	}
	
	@Override
	public void show() {
		contectDao.show();
	}


	@Override
	public void updateContect(String firstName, String lastName, String zipcode, String email,String street, int id) {
		
		contectDao.updateContect(firstName, lastName, zipcode, email,street,id);
	}

	
}
