package balda.venkatesh.expenses.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import balda.venkatesh.expenses.models.AccountsPojo;

@Repository
public interface AccountsRepo extends JpaRepository<AccountsPojo, Integer>{
	@Query("FROM AccountsPojo WHERE account_name=?1 ORDER BY account_name")
	List<AccountsPojo> getByAccount_name(String username);
}
