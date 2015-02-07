package databaseAccess;

import java.util.List;

import businessLogic.IRestObject;

public interface IDatabaseAccess {
	public List<IRestObject> getAll();
	public IRestObject get(int id);
	public void delete(int id);
	public IRestObject update(IRestObject user);
	public void create(IRestObject restObject);
}
