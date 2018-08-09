package com.revature.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.revature.abstractClasses.UserDao;
import com.revature.concreteClasses.BankAccount;
import com.revature.concreteClasses.Transaction;
import com.revature.concreteClasses.User;
import com.revature.exceptions.UserAlreadyExistsException;

//Probably allow user to close account, but they have to have a $0 balance first

public class UserDaoImplementation implements UserDao {

	private static final String USERNAME = "bank_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octohumphrey.cnwfdjrtsq2o.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	
	@Override
	public  int createUser(User person) {
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
			
			connection.setAutoCommit(false);
			String sql = "INSERT INTO users(username,password,fname,lname) Values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,person.getUsername());
			ps.setString(2,person.getPassword());
			ps.setString(3,person.getFname());	
			ps.setString(4,person.getLname());	
			rowsAffected = ps.executeUpdate();
			connection.commit();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public  List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM users WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				do {
				user = new User(rs.getInt("USERS_ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("FNAME"),rs.getString("LNAME"));
			} while (rs.next());}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int getUserBalance(User person) {
		BankAccount account = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, person.getUserID());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new BankAccount(rs.getInt("Account_Number"),rs.getInt("Balance"),rs.getInt("Users_Id"));
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int x = account.getBalance();
		return x;
			
	}

	@Override
	public int depositMoney(User person, int amount) {
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "{call update_account(?,?,?)}";
			String msg = "";
			CallableStatement callables = connection.prepareCall(sql);
			callables.setInt(1,person.getUserID());
			callables.setInt(2,amount);
			callables.setString(3,msg);
			rowsAffected = callables.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsAffected;
	}
	
	@Override
	public int withdrawMoney(User person, int amount) {
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "{call withdraw_account2(?,?,?)}";
			int affected = 0;
			CallableStatement callables = connection.prepareCall(sql);
			callables.registerOutParameter(3, Types.INTEGER);
			callables.setInt(1,person.getUserID());
			callables.setInt(2,amount);
			callables.setInt(3,affected);
			rowsAffected = callables.executeUpdate();
			connection.commit();
			rowsAffected = callables.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsAffected;
	}
	
	
	public User checkIfExists(String username) throws UserAlreadyExistsException{
		User user = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				do {
				user = new User(rs.getInt("USERS_ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("FNAME"),rs.getString("LNAME"));
			} while (rs.next());}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user != null) {
			throw new UserAlreadyExistsException();
		}
		return user;
		
	}
	
	@Override
	public int txDeposit(int id,int amount) {
		BankAccount account = null;
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new BankAccount(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
			int accountNumber = account.getAccountNumber();
			String sql2 = "INSERT INTO bank_tx(tx_amt,tx_type_id,account_number) VALUES(?,?,?)";
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, amount);
			ps2.setInt(2, 1);
			ps2.setInt(3, accountNumber);
			rowsAffected = ps2.executeUpdate();
			
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public int txWithdraw(int id,int amount) {
		BankAccount account = null;
		int rowsAffected = 0;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new BankAccount(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
			int accountNumber = account.getAccountNumber();
			String sql2 = "INSERT INTO bank_tx(tx_amt,tx_type_id,account_number) VALUES(?,?,?)";
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, amount);
			ps2.setInt(2, 2);
			ps2.setInt(3, accountNumber);
			rowsAffected = ps2.executeUpdate();
			
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public List<Transaction> viewTransaction(int id) {
		List<Transaction> userTxs = new ArrayList<>();
		BankAccount account = null;
		try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
			connection.setAutoCommit(false);
			String sql = "SELECT * FROM bank_account WHERE users_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account = new BankAccount(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
			int accountNumber = account.getAccountNumber();
			String sql2 = "SELECT * FROM bank_tx WHERE account_Number= ?";
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, accountNumber);
			ResultSet resultSet = ps2.executeQuery();
			while (resultSet.next()) {
				Transaction tx = new Transaction(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(5),resultSet.getInt(4));
				userTxs.add(tx);
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userTxs;
}
}
