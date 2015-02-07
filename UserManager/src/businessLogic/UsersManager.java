package businessLogic;

import java.util.Date;
import java.util.List;
import databaseAccess.UsersDAO;
import databaseAccess.IDatabaseAccess;


public class UsersManager {
	
	//TODO; Make sure this is the correct place to put this enum
	public enum status {
		OK,
		NOT_FOUND,
		CONFLICT,
		BAD_REQUEST,		
	}
	
	private IDatabaseAccess theUsersDAO;
	
	public UsersManager (){
		theUsersDAO = new UsersDAO();
	}
	
	public List<IRestObject> getAllUsers(){
		return theUsersDAO.getAll();
	}
	
	public IRestObject create(
			String username,String password,
			String name){
		//TODO: Check if username is proper email address 
		IRestObject aUser = new User (username,password,
				name);
		theUsersDAO.create(aUser);
		return aUser;
	}
	
	public IRestObject get(int id){
		return theUsersDAO.get(id);
	}
	
	public void delete(int id){
		theUsersDAO.delete(id);
	}
	
	public IRestObject update(IRestObject aUser){
		return theUsersDAO.update(aUser);
	}
}
