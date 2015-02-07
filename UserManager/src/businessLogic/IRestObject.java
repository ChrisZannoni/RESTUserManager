package businessLogic;

import java.util.Date;

import businessLogic.User.UserViewModel;

public interface IRestObject {
	public int getId();	
	public UserViewModel getViewModel();	
	public Date getDateCreated();
	public Date getDateModified();
}
