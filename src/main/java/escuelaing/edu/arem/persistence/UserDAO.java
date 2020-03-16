package escuelaing.edu.arem.persistence;

import java.util.Collection;

import escuelaing.edu.arem.model.User;

public interface UserDAO {
	
	/**
	 * Method that returns a collection of all users
	 * @return Collection of users
	 */
	public Collection<User> getAllUsers();
	
	/**
	 * Method to add a new user
	 * @param user New user
	 */
	public void addUser(User user);

}
