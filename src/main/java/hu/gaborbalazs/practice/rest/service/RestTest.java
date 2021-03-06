package hu.gaborbalazs.practice.rest.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.cdi.iface.Message;
import hu.gaborbalazs.practice.cdi.impl.CDITestBean;
import hu.gaborbalazs.practice.ejb.ServiceEjb;
import hu.gaborbalazs.practice.interceptor.Loggable;
import hu.gaborbalazs.practice.rest.response.PersonResponse;

@Path("resttest")
@Loggable
public class RestTest {

	@Inject
	private Logger logger;

	@Inject
	private ServiceEjb serviceEjb;

	@Inject
	private Message message;

	@Inject
	private CDITestBean cdiTestBean;

	@PostConstruct
	private void init() {
	}

	@GET
	@Path("echo")
	@Produces(MediaType.TEXT_PLAIN)
	public String echo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello World!");
		stringBuilder.append("\n");
		stringBuilder.append("Did you know that 4 + 5 = ");
		stringBuilder.append(serviceEjb.add(4, 5));
		stringBuilder.append("?");
		return stringBuilder.toString();
	}

	@GET
	@Path("cdi")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cdi() {
		logger.info("Message: " + message.getMessage());
		logger.info("cdiTestBean: " + cdiTestBean.toString());
		return Response.ok(message.getMessage()).build();
	}

	@GET
	@Path("exception")
	@Produces(MediaType.TEXT_PLAIN)
	public String exceptionTest() {
		throw new IllegalStateException("Exception Test");
	}

	@GET
	@Path("person")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonResponse getPerson() {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setName("Bob");
		personResponse.setAge(35);
		return personResponse;
	}
}
