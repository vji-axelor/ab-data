package com.ab.data.application;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ab.data.model.DemoData;
import com.ab.data.pojo.Contect;
import com.ab.data.service.ContectService;
import com.google.inject.Inject;

@Path("contact")
public class ContactService {
	DemoData db = new DemoData();

	ContectService cs = null;

	@Inject
	public ContactService(ContectService cs) {
		super();
		this.cs = cs;
	}

	@GET
	@Path("contectxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Contect> getAllContectXml() {
		List<Contect> list = cs.getContectList();
		return list;
	}

	@GET
	@Path("contectjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contect> getAllContectJson() {
		List<Contect> list = cs.getContectList();
		return list;
	}

	@GET
	@Path("singlecontect/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Contect getAllContectList(@PathParam("id") int id) { // return single contact

		return cs.getSingleContect(id);
	}

	@DELETE
	@Path("deleteuser/{id}")
	public void DeleteContect(@PathParam("id") int id) { // delete existing contact
//		db.deleteContect(id);
		cs.deleteContect(id);
	}

	@POST
	@Path("updateuser/{id}")
	public void update(@PathParam("id") int id, Contect contect) {

		Contect con = new Contect("demo", "demo", "12122", "demo@gmail.com", "street");
		db.updateContect(id, con);
	}

	@PUT
	@Path("adduser")
	public void addContect(Contect contect) {
//		db.addContect(contect);				//Test code for Hash map

		Contect con = new Contect("demo", "demo", "12122", "demo@gmail.com", "street");
		boolean res = cs.addContect(con.getFirstName(), con.getLastName(), con.getZipcode(), con.getEmail(),
				con.getStreet());
	}

}
