package hu.gaborbalazs.practice.rest;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import hu.gaborbalazs.practice.ejb.ServiceEjb;

@Path("resttest")
public class RestTest {

	@Inject
	private Logger logger;

	@Inject
	private ServiceEjb serviceEjb;

	@PostConstruct
	private void init() {
		logger.trace(">> init()");
	}

	@GET
	@Path("echo")
	@Produces(MediaType.TEXT_PLAIN)
	public String echo() {
		logger.trace(">> echo()");

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello World!");
		stringBuilder.append("\n");
		stringBuilder.append("Did you know that 4 + 5 = ");
		stringBuilder.append(serviceEjb.add(4, 5));
		stringBuilder.append("?");

		logger.trace("<< echo()");

		return stringBuilder.toString();
	}
}
