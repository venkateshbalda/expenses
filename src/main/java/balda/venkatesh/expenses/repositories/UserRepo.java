package balda.venkatesh.expenses.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import balda.venkatesh.expenses.models.UserPojo;

@Repository
public interface UserRepo extends JpaRepository<UserPojo,Integer>{
	Optional<UserPojo> getUserByusername(String username);
}
