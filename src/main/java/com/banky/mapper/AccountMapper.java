package com.banky.mapper;

import com.banky.dto.AccountDto;
import com.banky.dto.LoginDto;
import com.banky.entities.UserAccount;

public class AccountMapper {
	
	public static UserAccount mapToAccount(AccountDto accountDto) {
		
		//UserAccount userAccount = new UserAccount();

		UserAccount userAccount = new UserAccount(
				accountDto.getAccountId(),
				accountDto.getFirstName(),
				accountDto.getLastName(),
				accountDto.getEmail(),
				accountDto.getPassword(),
				accountDto.getConfirmPassword(),
				accountDto.getDob(),
				accountDto.getGender(),
				accountDto.getBalance(),
				accountDto.getDepositAmount(),
				accountDto.getTransferAmount(),
				accountDto.getWithdrawAmount()
				);
		return userAccount;
	}
	
	public static AccountDto mapToAccountDto(UserAccount userAccount) {
		
		AccountDto accountDto = new AccountDto(
				userAccount.getAccountId(),
				userAccount.getFirstName(),
				userAccount.getLastName(),
				userAccount.getEmail(),
				userAccount.getPassword(),
				userAccount.getConfirmPassword(),
				userAccount.getDob(),
				userAccount.getGender(),
				userAccount.getBalance(),
				userAccount.getDepositAmount(),
				userAccount.getTransferAmount(),
				userAccount.getWithdrawAmount());
		
		
		return accountDto;
	}
	
	public static LoginDto mapToLoginAccountDto(UserAccount userAccount) {
		
		LoginDto loginDto = new LoginDto(userAccount.getAccountId(),
									userAccount.getEmail(),userAccount.getPassword(),
									userAccount.getBalance(),
									userAccount.getDepositAmount(),
									userAccount.getTransferAmount(),
									userAccount.getWithdrawAmount());
		return loginDto;
	}
}

