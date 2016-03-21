/*package Communication;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import ReseauBat.Actionneur;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;



@Path("/switch")
public class ServeurREST {
	
	
	// The @Context annotation allows us to have certain contextual objects // injected into this class.
	// UriInfo object allows us to get URI information (no kidding). 
	@Context
	UriInfo uriInfo;
	
	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's address. 
	@Context
	Request request;
	
	// Basic "is the service running" test
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public String ready(){	
		KNXNetworkLinkIP link = Actionneur.link;
		return "We are ready !";
	}
	
}*/
