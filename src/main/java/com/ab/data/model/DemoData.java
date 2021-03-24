package com.ab.data.model;

import java.util.HashMap;
import java.util.List;

import com.ab.data.pojo.Contect;

public class DemoData {
	public HashMap<Integer,Contect> hm = new HashMap<Integer,Contect>();
	int flag = 0;
	
	public DemoData() {
		Contect con1 = new Contect("demo","demo","12122","demo@gmail.com","street");
		Contect con2 = new Contect("demo2","demo2","22222","demo2@gmail.com","street2");
		Contect con3 = new Contect("demo3","demo3","33333","demo3@gmail.com","street3");
		hm.put(++flag, con1);
		hm.put(++flag, con2);
		hm.put(++flag, con3);
	}
	
	public HashMap<Integer,Contect> getContectMap() {
		return hm;
	}
	
	public Contect getSingleContect(int id) {
	
		return hm.get(id);
	}
	
	public void deleteContect(int id) {
		hm.remove(id);
	}
	
	public void updateContect(int id,Contect contact) {
		
		hm.put(id, contact);
		
	}
	
	
	public void addContect(Contect contact) {
		hm.put(++flag,contact);
	}
	
	
	public List<Contect> getContectList(){
		return (List<Contect>) hm.values();
	}

	
}
