package com.banky.service;

import org.springframework.stereotype.Service;
import com.banky.dto.AccountDto;
import com.banky.dto.LoginDto;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface AccountOperationsService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getCustomerAccountById(int id);

    LoginDto loginByEmailAndPassword(String email , String password);
	
    AccountDto depositAmount(int id,double amount);
	
	AccountDto WithdrawAmount(int id,double amount);

	AccountDto moneyTransfer(int toCustomerId, int fromCustomerId, double transferAmount, HttpServletRequest request);
}

