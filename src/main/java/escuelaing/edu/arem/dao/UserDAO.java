package escuelaing.edu.arem.dao;

import java.util.Collection;

import escuelaing.edu.arem.model.User;

public interface UserDAO {
	
	public Collection<User> getAllUsers();
	public void addUser(User user);

}
