package escuelaing.edu.arem.service;

import java.util.Collection;
import java.util.List;

import escuelaing.edu.arem.model.User;

public interface PatternsApplicationServices {
	
	public Collection<User> getAllUsers();
	public void addUser(User u);
}
