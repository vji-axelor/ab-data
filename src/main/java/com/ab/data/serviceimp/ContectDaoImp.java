package com.ab.data.serviceimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ab.data.pojo.Contect;
import com.ab.data.service.ContectDao;
import com.ab.data.utility.HibernateUtility;

public class ContectDaoImp implements ContectDao {
	SessionFactory sf;
	Session ss;
	Transaction tr;
	Query q;
	List<Contect> list;
	HibernateUtility hu = new HibernateUtility();

	public boolean addContect(String firstName, String lastName, String zipcode, String email, String street) {
		

		  if(email == null || email == "") {
			  return false;
		  }
		  
		  String sufix = email.substring(email.length() - 4 , email.length());
		  
		  
		  if(!sufix.equals(".com")){
			  return false;		// Not end with .com
		  }
		  
		  if(zipcode == null && email.length() != 5) {	// length validation
			  return false;
		  }
	
		
		Contect contact = new Contect();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setZipcode(zipcode);
		contact.setStreet(street);
		contact.setEmail(email);
		
		ss = hu.createSession();
		tr = ss.beginTransaction();
		int ans1 = (int) ss.save(contact);
		tr.commit();
		ss.close();

		if (ans1 != 0) {
			return true;
		} else {
			return false;
		}
	}

		public List<Contect> getContectList() {
		ss = hu.createSession();
		list = (List<Contect>) ss.createQuery("from Contect ").list();
		ss.close();
		return list;
	}

	public void deleteContect(int id) {
		ss = hu.createSession();
		Contect c = ss.load(Contect.class, id);
		tr = ss.beginTransaction();
		// q.executeUpdate();
		ss.delete(c);
		tr.commit();
		ss.close();
	}

	public Contect getSingleContect(int id) {
		ss = hu.createSession();
		Contect c = ss.get(Contect.class, id);
		return c;
	}

	@Override
	public void show() {
		System.out.println("Test....!!");
	}

	@Override
	public void updateContect(String firstName, String lastName, String zipcode, String email,String street, int id) {
		ss = hu.createSession();
		Contect con = ss.find(Contect.class, id);
		q = ss.createQuery("delete from Contect where cid=" + id + "");
		tr = ss.beginTransaction();
		q.executeUpdate();
		ss.update(con);
		tr.commit();

		ss.close();
	}

}
