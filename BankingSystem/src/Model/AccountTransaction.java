package Model;

import java.sql.Timestamp;

public class AccountTransaction {
	
	private int id;
	private AccountTransactionType transactionType;
	private double amount;
	private Timestamp transactionDate;
	private String description;
	private StatusType status;
	private Transaction transaction;
	private CurrencyType currency;
	private Account account;
	
	
	public AccountTransaction() {
		
	}
	
	public AccountTransaction(int id, AccountTransactionType transactionType, double amount, Timestamp transactionDate,
			String description,StatusType status,CurrencyType currency ,Transaction transaction,Account account) {
		
		this.id = id;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.status = status;
		this.currency = currency;
		this.transaction = transaction;
		this.account = account;
	}
	
	public AccountTransaction(int id, AccountTransactionType transactionType, double amount, Timestamp transactionDate,
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
	public AccountTransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(AccountTransactionType transactionType) {
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
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountTransaction [id=" + id + ", transactionType=" + transactionType.name() + ", amount=" + amount
				+ ", transactionDate=" + transactionDate + ", description=" + description + ", transaction=" + transaction
				+ "]";
	}
	
}
