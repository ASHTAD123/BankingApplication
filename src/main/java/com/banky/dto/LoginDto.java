package com.banky.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginDto {
	
	private int accountId;
	
	@NotEmpty(message = "Email can't be empty!")
	@Size(min=3,max=30,message = "Email should contain only 3-30 characters")
	private String email;
	
	@NotEmpty(message = "Password can't be empty!")
	@Size(min=8,max=16,message = "Password should contain between 8-16 characters")
	private String password;

	private double balance;
	    
	private Double depositAmount;

	private Double transferAmount;
		
	private Double  withdrawAmount;

	public LoginDto() {
		super();
	}

	public LoginDto(int accountId,
			@NotEmpty(message = "Email can't be empty!") @Size(min = 3, max = 30, message = "Email should contain only 3-30 characters") String email,
			@NotEmpty(message = "Password can't be empty!") @Size(min = 8, max = 16, message = "Password should contain between 8-16 characters") String password,
			double balance, Double depositAmount, Double transferAmount, Double withdrawAmount) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.depositAmount = depositAmount;
		this.transferAmount = transferAmount;
		this.withdrawAmount = withdrawAmount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(Double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	
}