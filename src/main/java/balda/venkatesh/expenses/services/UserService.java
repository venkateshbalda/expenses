package balda.venkatesh.expenses.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import balda.venkatesh.expenses.models.UserPojo;
import balda.venkatesh.expenses.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	public UserPojo createUser(UserPojo userPojo) {
		//userPojo.setPassword(new BCryptPasswordEncoder().encode(userPojo.getPassword()));
		System.out.println(userPojo.getId());
		return userRepo.save(userPojo);
	}
	
	public Optional<UserPojo> getUserByUsername(String username){
		return userRepo.getUserByusername(username);
	}
	
	public Optional<UserPojo> getUserById(Integer id){
		return userRepo.findById(id);
	}
	
	public UserPojo updateUser(UserPojo updatedUserPojo) throws UserNotFoundException{
		Optional<UserPojo> optionalUser = userRepo.findById(updatedUserPojo.getId());
		if(optionalUser.isPresent()) {
			UserPojo user = optionalUser.get();
			user.setUsername(updatedUserPojo.getUsername());
			user.setPassword(updatedUserPojo.getPassword());
			user.setRole(updatedUserPojo.getRole());
			return userRepo.save(user);
		}
		else {
			throw new UserNotFoundException("the user is not found"+updatedUserPojo.getId());
		}
		
		
	}
}
