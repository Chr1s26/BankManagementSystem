package Model;

import java.sql.Date;

public class Account {
	
	private int id;
	private String accountNumber;
	private String accountType;
	private double balance;
	private Date createdAt;
	private Branch branch;
	private Customer customer;	
	
	public Account() {
		
	}
	
	public Account(int id, String accountNumber, String accountType, double balance,Date createdAt ,Branch branch,
			Customer customer) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.createdAt = createdAt;
		this.branch = branch;
		this.customer = customer;
	}
	
	public Account(String accountNumber, String accountType, double balance,Branch branch,Customer customer) {
	
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.branch = branch;
		this.customer = customer;
	}
	
	public Account(int id, String accountNumber, String accountType, double balance,Date createdAt) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getaccountNumber() {
		return accountNumber;
	}

	public void setaccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getaccountType() {
		return accountType;
	}

	public void setaccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balance=" + balance + ", createdAt=" + createdAt + ", branch=" + branch + ", customer="
				+ customer + "]";
	}
	
	
	
}
