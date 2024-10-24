package com.banky.controllers;

import com.banky.dto.AccountDto;
import com.banky.dto.LoginDto;
import com.banky.entities.UserAccount;
import com.banky.service.AccountOperationsService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountOperationsController {

	@Autowired
	 private AccountOperationsService accountOperationsService;
	
	
	  @GetMapping("/depositForm")
	  public String depositForm(Model model) {
		  
		  System.out.println("----- depsoit form ()-----");	  
		  System.out.println("");
		  model.addAttribute("deposit",new UserAccount());
	     
		  return "deposit";  
	  }
	  
	  @PostMapping("/deposit")
	  public String depositSave(@ModelAttribute("deposit") UserAccount user,HttpServletRequest request ) {

		  System.out.println("-----depositSave ()-----");
		  
		  //Getting model object
		  System.out.println(user.toString());
		
		  LoginDto account = (LoginDto)request.getSession().getAttribute("login");
		  
		  System.out.println("");
		  
		  System.out.println("----- data from user login session -----");
		  System.out.println(" Account Id: " + account.getAccountId());
		  System.out.println(" Account balance: " +account.getBalance());
	   
		  Double depositAmount =(Double)user.getDepositAmount();
		  
		  System.out.println("Deposit amount from user : "+ depositAmount);
		  AccountDto updatedAccountDTO = accountOperationsService.depositAmount(account.getAccountId(), depositAmount);

		  return "deposit";
		  
		  }

		  @GetMapping("/withdrawForm")
		  public String withdrawForm(Model model) {
			  
			  System.out.println("----- withdraw form ()-----");	  
			  System.out.println("");
			  model.addAttribute("withdraw",new UserAccount());
		     
			  return "withdraw";  
		  }
	  
		  @PostMapping("/withdraw")
		  public String withdrawSave(@ModelAttribute("withdraw") UserAccount user,HttpServletRequest request) {
		
			  LoginDto account = (LoginDto)request.getSession().getAttribute("login");
			 
			  System.out.println("-----withdrawSave ()-----");
			  System.out.println("");
			  
			  
			  System.out.println("----- data from user login session -----");
			  System.out.println(" Account Id: " + account.getAccountId());
			  System.out.println(" Account balance: " +account.getBalance());
		   
			  Double withdrawAmount =(Double)user.getWithdrawAmount();
			  AccountDto updatedAccountDTO = accountOperationsService.WithdrawAmount(account.getAccountId(), withdrawAmount);
	
			  return "withdraw";
			  
			  }
		  
		  @GetMapping("/transferForm")
		  public String transferForm(Model model) {
			  
			  System.out.println("----- Transfer form ()-----");	  
			  System.out.println("");
			  model.addAttribute("transferForm",new UserAccount());
		     
			  return "transferForm";  
		  }
	  
		  @PostMapping("/processTransfer")
		  public String processTransfer(@ModelAttribute("transferForm") UserAccount user ,HttpServletRequest request) {
			
			  System.out.println("----- processTransfer ()-----");
			 
			  //Getting model object
			  int toCutomerId = user.getAccountId();
			  System.out.println("To customer id : " + toCutomerId);
			  
			  //from session 
			  System.out.println("----- data from user login session -----");
			
			  LoginDto account = (LoginDto)request.getSession().getAttribute("login");
			  int fromCustomerId = account.getAccountId();
			
			  System.out.println(" From customer id : " + fromCustomerId); 	  
			  System.out.println(" From Account balance: " +account.getBalance());
		   
			  double transferAmount = user.getTransferAmount();
			  System.out.println("Transfer Amount " + transferAmount);
			  
			  AccountDto updatedAccountDTO = accountOperationsService.moneyTransfer(toCutomerId,fromCustomerId,transferAmount,request);
	
			  return "transferForm";
			  
			  }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	
}
