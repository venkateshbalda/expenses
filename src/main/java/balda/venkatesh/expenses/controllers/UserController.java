package balda.venkatesh.expenses.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import balda.venkatesh.expenses.models.UserPojo;
import balda.venkatesh.expenses.repositories.UserRepo;
import balda.venkatesh.expenses.services.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String UserController() {
		return("home page");
	}
	
	@PostMapping("/adduser")
	public UserPojo createUser(@RequestBody UserPojo userPojo) {
		return userService.createUser(userPojo);
	}
	
	@GetMapping("/getuserbyname/{username}")
	public Optional<UserPojo> getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@GetMapping("/getuserbyid/{id}")
	public Optional<UserPojo> getUserById(@PathVariable Integer id) {
		System.out.println(userService.getUserById(id));
		return userService.getUserById(id);
	}
}
