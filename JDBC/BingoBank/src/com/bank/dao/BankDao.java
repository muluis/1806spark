package com.bank.dao;

import com.bank.pojos.BankAccount;
import com.bank.pojos.User;
import com.bank.service.InvalidAmountException;

public interface BankDao {
	
	//CREATE
	//public BankAccount createAccount(String username, String password);
	
	//READ
	public User getUserLogin ();
	public BankAccount getBalance(int usersId);
	
	//UPDATE
	public void makeDeposit(int deposit);
	public void makeWitdrawl(int witdrawl) throws InvalidAmountException;

	//DELETE
}
