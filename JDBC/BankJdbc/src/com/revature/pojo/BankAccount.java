package com.revature.pojo;

public class BankAccount {
	
	private static BankAccount currentAccount = null;

	//states
	private int accountNumber;
	private double balance;
	private int usersId;
	
	//constructor using fields
	public BankAccount(int accountNumber, double balance, int usersId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.usersId = usersId;
	}
	
	//NO-ARGS constructor
	public BankAccount() {}

	//getters n' setters
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public static BankAccount getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(BankAccount currentAccount) {
		BankAccount.currentAccount = currentAccount;
	}
	
	@Override
	public String toString() {
		return "Account Number=" + accountNumber + ", Balance=" + balance ;
	}
}