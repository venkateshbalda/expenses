package balda.venkatesh.expenses.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import balda.venkatesh.expenses.models.AccountsPojo;
import balda.venkatesh.expenses.repositories.AccountsRepo;
import balda.venkatesh.expenses.repositories.UserRepo;

@Service
public class AccountsService {
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	
	public AccountsPojo createAccount(AccountsPojo accountsPojo) {
		return accountsRepo.save(accountsPojo);
	}
	public String deleteAccount(Integer id) {
		accountsRepo.deleteById(id);
		return ("account deleted");
	}
	
	public AccountsPojo updateAccount(AccountsPojo accountsPojo) {
		int aid = accountsPojo.getId();
		AccountsPojo accounts = accountsRepo.getById(aid);
		accounts.setId(aid);
		//account name
		if(accountsPojo.getAccount_name()!=null) {
			accounts.setAccount_name(accountsPojo.getAccount_name());
		}else {
			accounts.setAccount_name(accounts.getAccount_name());
		}
		//amount
		if(accountsPojo.getAmount()!=null) {
			accounts.setAmount(accountsPojo.getAmount());
		}else {
			accounts.setAmount(accounts.getAmount());
		}
		//user id
		if(accountsPojo.getUserPojo()!=null) {
			accounts.setUserPojo(accountsPojo.getUserPojo());
		}else {
			accounts.setUserPojo(accounts.getUserPojo());
		}
		
		return accountsRepo.save(accounts);
	}
	
	public void subExpenseAmount(Integer aid, BigDecimal amount) {
		AccountsPojo accounts = accountsRepo.getById(aid);
		accounts.setId(aid);
		accounts.setAccount_name(accounts.getAccount_name());
		accounts.setUserPojo(accounts.getUserPojo());
		accounts.setAmount(accounts.getAmount().subtract(amount));
		accountsRepo.save(accounts);
	}
	
	public void addExpenseAmount(Integer aid, BigDecimal amount) {
		AccountsPojo accounts = accountsRepo.getById(aid);
		accounts.setId(aid);
		accounts.setAccount_name(accounts.getAccount_name());
		accounts.setUserPojo(accounts.getUserPojo());
		accounts.setAmount(accounts.getAmount().add(amount));
		accountsRepo.save(accounts);
	}
	
	public List<AccountsPojo> getAllAccounts() {
		return accountsRepo.findAll();
	}
	
	public AccountsPojo getAccountById(Integer id) {
		return accountsRepo.getById(id);
	}
	
	public List<AccountsPojo> getAccountByName(String accountname) {
		return accountsRepo.getByAccount_name(accountname);
	}
}
