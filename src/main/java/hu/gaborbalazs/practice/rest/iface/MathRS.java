package hu.gaborbalazs.practice.rest.iface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("math")
@Produces(MediaType.APPLICATION_JSON)
public interface MathRS {

	@GET
	@Path("random")
	public Response randomNumber();
}
