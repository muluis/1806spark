package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Transaction;

import oracle.jdbc.internal.OracleTypes;

public class TransactionDaoImpl implements TransactionDao{
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@revaturedb.cszwhyxgdjx2.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public int createTx(Transaction tx) {
		Transaction trans = (Transaction) tx;
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_bank_tx(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, trans.getTxAmt());
			cs.setString(2, trans.getTxType());
			cs.setInt(3, trans.getAccountNum());
			System.out.println("Congratulations!!! Your transaction went through");
			rowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public void createTxProc(Transaction tx) {
		
	}

	@Override
	public List<Transaction> readTx() {
		List<Transaction> transaction = new ArrayList<>();
		BankAccount account = BankAccount.getPresentAccount();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call retrieve_transc(?,?)";
			String name = null ;
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, account.getAccountNum());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				Transaction tx = new Transaction(rs.getInt(1), rs.getDouble(2), rs.getString("tx_type"), rs.getInt(4));
				transaction.add(tx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}

	@Override
	public Transaction getTxById(int id) {
		return null;
	}

	@Override
	public int updateTx(Transaction tx) {
		return 0;
	}

}