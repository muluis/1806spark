package com.revature.pojo;

public class Transaction {
	
	//	state
	private int txId;
	private Double txAmt;
	private String txType;
	private int acNum;
	
	//	no-args constructor
	public Transaction() {
		super();
	}

	public Transaction(int txId, Double txAmt, String txType, int acNum) {
		super();
		this.txId = txId;
		this.txAmt = txAmt;
		this.txType = txType;
		this.acNum = acNum;
	}
	
	public Transaction(Double txAmt, String txType, int acNum) {
		this.txAmt = txAmt;
		this.txType = txType;
		this.acNum = acNum;
	}

	//	getters and setters
	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public Double getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(Double txAmt) {
		this.txAmt = txAmt;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public int getAcNum() {
		return acNum;
	}

	public void setAcNum(int acNum) {
		this.acNum = acNum;
	}

	//	toString
	@Override
	public String toString() {
		return "Transaction [Transaction ID = " + txId + ", Amount = $" + txAmt + ", Transaction Type = " + txType + ", Account Number = " + acNum + "]";
	}

}