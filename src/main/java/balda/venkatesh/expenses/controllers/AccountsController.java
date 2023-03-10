package balda.venkatesh.expenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import balda.venkatesh.expenses.models.AccountsPojo;
import balda.venkatesh.expenses.models.UserPojo;
import balda.venkatesh.expenses.repositories.AccountsRepo;
import balda.venkatesh.expenses.repositories.UserRepo;
import balda.venkatesh.expenses.services.AccountsService;
import balda.venkatesh.expenses.services.UserService;

@CrossOrigin
@RestController
public class AccountsController {
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	AccountsService accountsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/addaccount")
	public AccountsPojo createAccount(@RequestBody AccountsPojo accountsPojo) {
		return accountsService.createAccount(accountsPojo);
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	public String deleteAccount(@PathVariable("id") Integer id) {
		return accountsService.deleteAccount(id);
	}
	
	@PostMapping("/updateaccount")
	public AccountsPojo updateAccount(@RequestBody AccountsPojo accountsPojo) {
		return accountsService.updateAccount(accountsPojo);
	}
	
	@GetMapping("/getaccounts")
	public List<AccountsPojo> getAllAccounts() {
		return accountsService.getAllAccounts();
	}
	
	@GetMapping("/getaccountbyid/{id}")
	public AccountsPojo getAccountbyId(@PathVariable("id") Integer id) {
		return accountsService.getAccountById(id);
	}
	
	@GetMapping("/getaccountbyname/{accountname}")
	public List<AccountsPojo> getAccountByName(@PathVariable String accountname){
		return accountsService.getAccountByName(accountname);
	}
	
}
