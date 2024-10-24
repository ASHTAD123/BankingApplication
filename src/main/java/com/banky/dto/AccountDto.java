package com.banky.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AccountDto {
	
	private int accountId;
	
	@NotBlank(message = "First Name can't be empty!")
	@Size(min=3,max=20,message = "First name should contain only 3-20 characters")
	private String firstName;
	
	//@NotBlank(message = "Last Name can't be empty!")
	//@Size(min=3,max=20,message = "Last name should contain only 3-20 characters")
	private String lastName;
	
	@NotBlank(message = "Email can't be empty!")
	@Column(unique=true)
	@Size(min=3,max=30,message = "Email should contain only 3-30 characters")
	private String email;
	
	@NotBlank(message = "Password can't be empty!")
	@Size(min=8,max=16,message = "Password should contain between 8-16 characters")
	private String password;

	@NotBlank(message = "Confirm Password can't be empty!")
	@Size(min=8,max=16,message = "Password should contain between 8-16 characters")
	private String confirmPassword;
	
	private Date dob;

	private String gender;

    private double balance;
    
    private Double depositAmount;

    private Double transferAmount;
	
    private Double  withdrawAmount;

    
	public AccountDto() {
		super();
	}

	public AccountDto(int accountId, String firstName, String lastName, String email, String password,
			String confirmPassword, Date dob, String gender, double balance, Double depositAmount,
			Double transferAmount, Double withdrawAmount) {
		
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dob = dob;
		this.gender = gender;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

