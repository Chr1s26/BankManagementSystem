package DTO;

import Model.AccountTransactionType;

public class TransactionDTO {
	
	private int transactionId;
	private AccountTransactionType Type;
	private String createdAt;
	private String Number;
	private double amount;
	private String description;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public AccountTransactionType getType() {
		return Type;
	}
	public void setType(AccountTransactionType Type) {
		this.Type = Type;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String accountNumber) {
		this.Number = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
