package org.bhargav.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bhargav.model.Todo;

@Path("/hello")
public class HelloWorldWebService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say 123 : " + msg;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}
	
	@GET
	@Path("/json")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Todo getXML() {
		Todo todo = new Todo();
	    todo.setSummary("This is my first todo");
	    todo.setDescription("This is my first todo");
	    return todo;
	}
}
