package balda.venkatesh.expenses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import balda.venkatesh.expenses.models.ExpensePojo;

@Repository
public interface ExpenseRepo extends JpaRepository<ExpensePojo, Integer>{

}
