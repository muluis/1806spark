package com.revature.businesslogic;

import java.util.List;

import com.revature.dao.BankAccountDaompl;
import com.revature.dao.TransactionDaompl;
import com.revature.dao.UserDaompl;
import com.revature.exceptions.OverdraftException;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;
import com.revature.pojo.User;

public class Service {
	
	
	//	Validate user info
	//	Return true if user exists, false otherwise

	public static boolean userExists(String username, String password) {
		UserDaompl users = new UserDaompl();
		List<User> userList = users.readUser();
		for (User u : userList) {
			User user = (User) u;
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				User.setCurrentUser(user);
				return true;
			}
		}
		return false;
	}
	

	//	Finds the current user's bank account
	
	public static void applyUserAccount(int userId) {
		BankAccountDaompl accountDao = new BankAccountDaompl();
		BankAccount userAccount = accountDao.getAccountById(userId);
		BankAccount.setCurrentAccount(userAccount);
	}
	
	//	Deposit to account
	
	public static void deposit(Double amount) {
		BankAccount account = BankAccount.getCurrentAccount();
		Double balance = account.getBalance();
		account.setBalance(balance + amount);
		new BankAccountDaompl().updateAccount(account);
		Transaction tx = new Transaction(amount, "Deposit", account.getAcNum());
		new TransactionDaompl().createTx(tx);
	}

	//	Withdraw from account
	public static void withdrawl(Double amount) throws OverdraftException {
		BankAccount account = BankAccount.getCurrentAccount();
		Double balance = account.getBalance();
		if (balance - amount > 0) {
			account.setBalance(balance - amount);
			new BankAccountDaompl().updateAccount(account);
			Transaction tx = new Transaction(amount, "Withdrawal", account.getAcNum());
			new TransactionDaompl().createTx(tx);
		}
		if (balance - amount < 0) {
			throw new OverdraftException();
		}
	}
	
}