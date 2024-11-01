package com.banky.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;



@Entity
@Table(name = "\"bankyUserAccounts\"", schema = "public")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountid")
	private int accountId;

	@Column(name = "\"firstName\"")
	private String firstName;

	@Column(name = "\"lastName\"")
	private String lastName;

	private String email;

	private String password;

	@Column(name = "confirmpass")
	private String confirmPassword;

	private Date dob;

	private String gender;

	private Double balance;

	@Column(name = "\"depositAmount\"")
	private Double depositAmount=0.0;

	@Column(name = "\"transferAmount\"")
	private Double transferAmount=0.0;

	@Column(name = "\"withdrawAmount\"")
	private Double withdrawAmount=0.0;

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccount(int accountId, String firstName, String lastName, String email, String password,
			String confirmPassword, Date dob, String gender, Double balance, Double depositAmount,
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
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
