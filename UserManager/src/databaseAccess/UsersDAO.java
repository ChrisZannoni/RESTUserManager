package databaseAccess;

import java.util.Date;
import java.util.List;

import businessLogic.IRestObject;
import businessLogic.User;



public class UsersDAO extends DatabaseManager{

	/** The name of the table we are testing with */
	private final String tableName = "users";
	
	public UsersDAO(){
		super();
	}
	
	public List<IRestObject> getAll(){
		return null;		
	}
	
	public IRestObject get(int id){
		return new User(id,"aUsername","aPassword","aName",new Date(),new Date());
	}
	
	public void delete(int Id){
	
	}
	
	public IRestObject update(IRestObject restObject){
		return null;
	}
	
	public void create(IRestObject restObject){
		//TODO: Check if username is unique and can come from a database key constraint
	}
}
