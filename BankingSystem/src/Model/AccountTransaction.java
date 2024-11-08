package Model;

import java.sql.Timestamp;

public class AccountTransaction {
	
	private int id;
	private String transactionType;
	private double amount;
	private Timestamp transactionDate;
	private String description;
	private Account account;
	
	
	public AccountTransaction(int id, String transactionType, double amount, Timestamp transactionDate,
			String description, Account account) {
		
		this.id = id;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.account = account;
	}
	
	public AccountTransaction(int id, String transactionType, double amount, Timestamp transactionDate,
			String description) {
		
		this.id = id;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountTransaction [id=" + id + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", transactionDate=" + transactionDate + ", description=" + description + ", account=" + account
				+ "]";
	}
	
}
