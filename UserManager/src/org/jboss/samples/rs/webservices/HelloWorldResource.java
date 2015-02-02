package org.jboss.samples.rs.webservices;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/MyRESTApplication")
public class HelloWorldResource {

	@GET()
	@Path("/helloworld")
	@Produces("text/plain")
	public String sayHello() {
	    DataBaseHelper app = new DataBaseHelper();
		app.run();
		return "Created DB";
	}
}
