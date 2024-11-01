package com.banky.service;

import com.banky.dto.AccountDto;
import com.banky.dto.LoginDto;
import com.banky.entities.UserAccount;
import com.banky.mapper.AccountMapper;
import com.banky.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationsServiceImplemenation implements AccountOperationsService {
 
 @Autowired
  private AccountRepository accountRepository;

	
  @Override
  public AccountDto createAccount(AccountDto accountDto) {
   
	 UserAccount userAccount = AccountMapper.mapToAccount(accountDto);
    UserAccount savedAccount = accountRepository.save(userAccount);

    return AccountMapper.mapToAccountDto(savedAccount);
  }

  @Override
  public LoginDto loginByEmailAndPassword(String email, String password) {
	  
	  UserAccount account = accountRepository.findByEmailAndPassword(email, password);

    if (account == null) {
      System.out.println("User Account is null");
    }

    return AccountMapper.mapToLoginAccountDto(account);
  }

	  @Override
	  public AccountDto depositAmount(int id, double amount) {
	  
		System.out.println(" ");
	    System.out.println("----- service layers depositAmount() -----");
	
	    Optional<UserAccount> account = accountRepository.findById(id);
	    UserAccount userAccount = account.get();
	
	    //Getting up curr balance
	    double currentBalance = userAccount.getBalance();
	    System.out.println("Current Balance : " + currentBalance);
	
	    //Amount to update with curr balance
	    System.out.println(" Amount passed by user : " + amount);
	    double updatedBalance = currentBalance + amount;
	
	    System.out.println(" Updated balance to be passed to user : " + updatedBalance);
	    userAccount.setBalance(updatedBalance);
	
	    UserAccount ac = accountRepository.save(userAccount);
	
	    return AccountMapper.mapToAccountDto(ac);
	  }
		
	
	  @Override
	  public AccountDto WithdrawAmount(int id, double amount) {
		  	
		  	System.out.println(" ");
		    System.out.println("----- service layers Withdraw Amount() -----");
		
		    //Getting user by id
		    Optional<UserAccount> account = accountRepository.findById(id);
		    UserAccount userAccount = account.get();
		
		    //Getting current balance
		    double currentBalance = userAccount.getBalance();
		    System.out.println("Current Balance : " + currentBalance);
		
		    //Amount to update with current balance
		    System.out.println(" Amount passed by user : " + amount);
		    double updatedBalance = currentBalance - amount;
		
		    System.out.println(" Updated balance to be passed to user : " + updatedBalance);
		    userAccount.setBalance(updatedBalance);
		
		    UserAccount ac = accountRepository.save(userAccount);
		
		    return AccountMapper.mapToAccountDto(ac);
	  }


	  	@Override 
	  	public AccountDto moneyTransfer(int toCustomerId, int fromCustomerId ,double amount, HttpServletRequest request){
	  		
	  		System.out.println(" ");
		    System.out.println("----- service layers moneyTransfer() -----");
	
		    UserAccount from_customer_ac = accountRepository.findById(fromCustomerId).get();
		    UserAccount to_customer_ac = accountRepository.findById(toCustomerId).get();
		    
		    double currBal_from_account = from_customer_ac.getBalance() - amount;
		    from_customer_ac.setBalance(currBal_from_account);
		    
		    double currBal_to_account = to_customer_ac.getBalance() + amount;
		    to_customer_ac.setBalance(currBal_to_account);
		   
		    UserAccount to_ac = accountRepository.save(from_customer_ac);
		    UserAccount from_ac = accountRepository.save(to_customer_ac);
	
		    return AccountMapper.mapToAccountDto(to_ac);
	  		
	  	}

	  		@Override 
	  		public AccountDto getCustomerAccountById(int id)
	  		{// TODO Auto-generated method stub

	  			
	  			return null;}

}
