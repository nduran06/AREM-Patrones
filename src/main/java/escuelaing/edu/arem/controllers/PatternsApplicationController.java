package escuelaing.edu.arem.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.arem.model.User;
import escuelaing.edu.arem.service.PatternsApplicationServices;

@RestController
@RequestMapping(value = "/patterns")
public class PatternsApplicationController {
	
	@Autowired
	private PatternsApplicationServices paServices;

	/**
	 * Method that returns all users 
	 * @return Collection of users
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<User>  getAllUsers() {
		return paServices.getAllUsers();
	}
	
	/**
	 * Method to add new user
	 * @param user New user
	 */
    @RequestMapping(method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user){
    	paServices.addUser(user);
	}
}
