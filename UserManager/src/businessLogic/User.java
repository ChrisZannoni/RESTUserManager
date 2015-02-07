package businessLogic;

import java.util.Date;

public class User implements IRestObject{
	
	private int id;	
	private String username;
	private String password;
	private String name;
	private Date dateCreated;
	private Date dateModified;
	
	public User(String username,String password,String name){
		this.username = username;
		this.password = password;
		this.name = name;
		//below fields must be populated from through the DAO
		this.dateCreated = null;
		this.dateModified = null;
	}
	
	
	/**
	 * Instantiates a new user used to restore from the Database.
	 *
	 * @param id the id
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param dateCreated the date created
	 */
	public User(int id, String username,String password,String name,Date dateCreated,Date dateModified){
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.dateModified = new Date();
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.dateModified = new Date();
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.dateModified = new Date();
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}
	
	//TODO: Figure out the best way to convert to a view model. An inner class is probably not the best.
	public UserViewModel getViewModel(){
		return new UserViewModel(username,name,dateCreated,dateModified);
	}

	public class UserViewModel {
		private String username;
		private String name;
		private Date dateCreated;
		private Date dateModified;
		
		public UserViewModel(String username,String name,Date dateCreated,Date dateModified){
			this.username = username;
			this.name = name;
			this.dateCreated = dateCreated;
			this.dateModified = dateModified;			
		}		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
