package escuelaing.edu.arem.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import escuelaing.edu.arem.dao.UserDAO;
import escuelaing.edu.arem.model.User;
import escuelaing.edu.arem.service.PatternsApplicationServices;

@Service
public class PatternsApplicationServicesImpl implements PatternsApplicationServices{
	
	@Autowired
	@Qualifier("postgresql")
	private UserDAO userDAO;

	@Override
	public Collection<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}

	@Override
	public void addUser(User u) {
		this.userDAO.addUser(u);
		
	}
	
	/*private UserRepository userRepository;
	
	public PatternsApplicationServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public void addUser(User u) {
		this.userRepository.save(u);
		
	}*/

}
