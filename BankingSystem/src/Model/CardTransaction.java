package Model;

import java.sql.Timestamp;

public class CardTransaction {
	
	private int id;
	private double amount;
	private Timestamp transactionDate;
	private String description;
	private Account account;
	private Card card;
	private StatusType status;
	private CurrencyType currency;
	private Transaction transaction;
	private AccountTransactionType type;
	
	
	public CardTransaction() {
		
	}
	
	public CardTransaction(double amount, String description, Account account,Card card,StatusType status,CurrencyType currency,Transaction transaction,AccountTransactionType type) {
		this.amount = amount;
		this.description = description;
		this.account = account;
		this.card = card;
		this.status = status;
		this.currency = currency;
		this.transaction = transaction;
		this.type = type;
	}
	
	public CardTransaction(int id,double amount,Timestamp transactionDate ,String description, Account account,Card card,StatusType status,CurrencyType currency,Transaction transaction,AccountTransactionType type) {
		this.amount = amount;
		this.description = description;
		this.account = account;
		this.card = card;
		this.status = status;
		this.currency = currency;
		this.transaction = transaction;
		this.type = type;
		this.transactionDate = transactionDate;
	}
	
	public CardTransaction(int id, double amount, Timestamp transactionDate, String description, Account account,Card card) {
	
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.account = account;
		this.card = card;
	}
	
	public CardTransaction(int id, double amount, Timestamp transactionDate, String description) {
		
		this.id = id;
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
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
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

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public AccountTransactionType getType() {
		return type;
	}

	public void setType(AccountTransactionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CardTransaction [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate
				+ ", description=" + description + ", account=" + account + ", card=" + card + "]";
	}
	
	
	
}
