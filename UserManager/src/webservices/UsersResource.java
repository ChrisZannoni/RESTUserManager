package webservices;

import java.util.List;

import javax.ejb.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import businessLogic.IRestObject;
import businessLogic.User;
import businessLogic.UsersManager;

@Singleton
@Path("/users")
public class UsersResource {
	UsersManager theUsersManager;
	
	private UsersManager getUsersManager(){
		if(theUsersManager == null){
			theUsersManager = new UsersManager();
		}
		return theUsersManager;
	}
	
	//TODO: Figure out sending and receiving object via JSON
	@GET()
	//@Produces("text/plain")
	public List<IRestObject> getAllUsers() {
		return getUsersManager().getAllUsers();
	}
	
	@POST()
	//@Produces("text/plain")
	public IRestObject createUser() {
		String username = "UserName1";
		String password = "password1";
		String name = "John Doe";

		return getUsersManager().create(username,password,name);
	}
	
	@GET()
	@Path("/{userId}")
	//@Produces("text/plain")
	public IRestObject getUser(@PathParam("userId") int id ) {
		return getUsersManager().get(id);
	}

	@PUT()
	@Path("/{userId}")
	//@Produces("text/plain")
	public IRestObject updateUser(@PathParam("userId") int id ) {
		//get user from JSON
		// *Note: below code is just a stub.
		String username = "UserName1";
		String password = "password1";
		String name = "John Doe";

		IRestObject aUser = new User(username,password,name);	
		return getUsersManager().update(aUser);
	}
	
	
	
	@DELETE()
	@Path("/{userId}")
	@Produces("text/plain")
	public String deleteUser(@PathParam("userId") String id) {		
		//getUsersManager().delete(id);
		return "DeletedUser " + id;
	}

}
