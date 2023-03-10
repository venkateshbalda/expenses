package balda.venkatesh.expenses.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import balda.venkatesh.expenses.models.ExpensePojo;
import balda.venkatesh.expenses.models.UserPojo;
import balda.venkatesh.expenses.repositories.ExpenseRepo;
import balda.venkatesh.expenses.repositories.UserRepo;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepo expenseRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	UserService userService;
	@Autowired
	AccountsService accountsService;
	
	public ExpensePojo createExpense(ExpensePojo expensePojo) {
		//BigDecimal amount = expensePojo.getAmount();
		accountsService.subExpenseAmount(expensePojo.getAccountid(), expensePojo.getAmount());
		return expenseRepo.save(expensePojo);
	}
	
	public Optional<ExpensePojo> getExpenseById(Integer id) {
		return expenseRepo.findById(id);
	}
	
	public List<ExpensePojo> getExpenseAll() {
		return expenseRepo.findAll();
	}
	
	public ExpensePojo updateExpense(ExpensePojo expensePojo) {
		System.out.println(expensePojo);
		int eid = expensePojo.getId();
		System.out.println(eid);
		ExpensePojo expense = expenseRepo.getById(eid);
		System.out.println(expense.getAmount());
		expense.setId(eid);
		//category
		if(expensePojo.getCategory()!=null) {
			expense.setCategory(expensePojo.getCategory());
		}else {
			expense.setCategory(expense.getCategory());
		}
		//date
		if(expensePojo.getDate()!=null) {
			expense.setDate(expensePojo.getDate());
		}else {
			expense.setDate(expense.getDate());
		}
		//description
		if(expensePojo.getDescription()!=null) {
			expense.setDescription(expensePojo.getDescription());
		}else {
			expense.setDescription(expense.getDescription());
		}
		//user id
		if(expensePojo.getUserPojo()!=null) {
			expense.setUserPojo(expensePojo.getUserPojo());
		}else {
			expense.setUserPojo(expense.getUserPojo());
		}
		//account id
		if(expensePojo.getAccountid()!=0) {
			expense.setAccountid(expensePojo.getAccountid());
		}else {
			expense.setAccountid(expense.getAccountid());
		}
		//type
		if(expensePojo.getType()!=null) {
			expense.setType(expensePojo.getType());
		}else {
			expense.setType(expense.getType());
		}
		//if amount is present update otherwise get the same value and update again
		if(expensePojo.getAmount()!=null) {
			System.out.println(expense.getAmount());
			accountsService.addExpenseAmount(expensePojo.getAccountid(), expense.getAmount());
			expense.setAmount(expensePojo.getAmount());
			System.out.println(expense.getAmount());
			accountsService.subExpenseAmount(expensePojo.getAccountid(), expense.getAmount());
		}else {
			expense.setAmount(expense.getAmount());
		}
		return expenseRepo.save(expense);
	}
	
	public String deleteExpense(Integer id) {
		ExpensePojo expense = expenseRepo.getById(id);
		accountsService.addExpenseAmount(expense.getAccountid(), expense.getAmount());
		expenseRepo.deleteById(id);
		return(id+"deleted");
	}
	
	public ExpensePojo createIncome(ExpensePojo expensePojo) {
		accountsService.addExpenseAmount(expensePojo.getAccountid(), expensePojo.getAmount());
		return expenseRepo.save(expensePojo);
	}
	
	public ExpensePojo updateIncome(ExpensePojo expensePojo) {
		System.out.println(expensePojo);
		int eid = expensePojo.getId();
		System.out.println(eid);
		ExpensePojo expense = expenseRepo.getById(eid);
		System.out.println(expense.getAmount());
		expense.setId(eid);
		//category
		if(expensePojo.getCategory()!=null) {
			expense.setCategory(expensePojo.getCategory());
		}else {
			expense.setCategory(expense.getCategory());
		}
		//date
		if(expensePojo.getDate()!=null) {
			expense.setDate(expensePojo.getDate());
		}else {
			expense.setDate(expense.getDate());
		}
		//description
		if(expensePojo.getDescription()!=null) {
			expense.setDescription(expensePojo.getDescription());
		}else {
			expense.setDescription(expense.getDescription());
		}
		//user id
		if(expensePojo.getUserPojo()!=null) {
			expense.setUserPojo(expensePojo.getUserPojo());
		}else {
			expense.setUserPojo(expense.getUserPojo());
		}
		//account id
		if(expensePojo.getAccountid()!=0) {
			expense.setAccountid(expensePojo.getAccountid());
		}else {
			expense.setAccountid(expense.getAccountid());
		}
		//type
		if(expensePojo.getType()!=null) {
			expense.setType(expensePojo.getType());
		}else {
			expense.setType(expense.getType());
		}
		//if amount is present update otherwise get the same value and update again
		if(expensePojo.getAmount()!=null) {
			System.out.println(expense.getAmount());
			accountsService.subExpenseAmount(expensePojo.getAccountid(), expense.getAmount());
			expense.setAmount(expensePojo.getAmount());
			System.out.println(expense.getAmount());
			accountsService.addExpenseAmount(expensePojo.getAccountid(), expense.getAmount());
		}else {
			expense.setAmount(expense.getAmount());
		}
		return expenseRepo.save(expense);
	}
	
}
