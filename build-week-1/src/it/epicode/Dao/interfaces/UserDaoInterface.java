package it.epicode.Dao.interfaces;

import it.epicode.entities.User;

public interface UserDaoInterface {

	public void addUser(User u);

	public void removeUser(int id);

	public void editUserSetName(int id, String n);

}
