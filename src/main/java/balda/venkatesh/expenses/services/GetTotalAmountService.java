package balda.venkatesh.expenses.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import balda.venkatesh.expenses.models.AccountsPojo;
import balda.venkatesh.expenses.repositories.AccountsRepo;
import balda.venkatesh.expenses.repositories.UserRepo;

@Service
public class GetTotalAmountService {
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public BigDecimal getTotalAmount(Integer uid) {
		BigDecimal totalAmount = BigDecimal.ZERO;;
		List<AccountsPojo> accounts = accountsRepo.findByUserPojo_Id(uid);
		for (AccountsPojo account : accounts) {
			totalAmount = account.getAmount().add(totalAmount);
		}
		return totalAmount;
	}
}
