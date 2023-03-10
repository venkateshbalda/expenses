package balda.venkatesh.expenses.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import balda.venkatesh.expenses.models.ExpensePojo;
import balda.venkatesh.expenses.repositories.ExpenseRepo;
import balda.venkatesh.expenses.services.ExpenseService;

@CrossOrigin
@RestController
public class ExpenseController {
	@Autowired
	ExpenseRepo expenseRepo;
	
	@Autowired
	ExpenseService expenseService;
	
	@PostMapping("/addexpense")
	public ExpensePojo createExpense(@RequestBody ExpensePojo expensePojo) {
		return expenseService.createExpense(expensePojo);
	}
	
	@GetMapping("/getexpense/{id}")
	public Optional<ExpensePojo> getExpenseById(@PathVariable Integer id) {
		return expenseService.getExpenseById(id);
	}
	
	@GetMapping("/getallexpense")
	public List<ExpensePojo> getExpenseAll(){
		return expenseService.getExpenseAll();
	}
	
	@PostMapping("/updateexpense")
	public ExpensePojo updateExpense(@RequestBody ExpensePojo expensePojo) {
		return expenseService.updateExpense(expensePojo);
	}
	
	@DeleteMapping("/deleteexpense/{id}")
	public String deleteExpense(@PathVariable("id") Integer id) {
		return expenseService.deleteExpense(id);
	}
	
	@PostMapping("/addincome")
	public ExpensePojo createIncome(@RequestBody ExpensePojo expensePojo) {
		return expenseService.createIncome(expensePojo);
	}
	
	@PostMapping("/updateincome")
	public ExpensePojo updateIncome(@RequestBody ExpensePojo expensePojo) {
		return expenseService.updateIncome(expensePojo);
	}
}
