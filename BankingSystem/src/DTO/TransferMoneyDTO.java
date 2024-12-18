package DTO;

import Model.Account;
import Model.CurrencyType;
import Model.Employee;

public class TransferMoneyDTO {
	
	private Account sourceAccountNum;
	private Account targetAccountNum;
	private double amount;
	private String description;
	private CurrencyType currency;
	private Employee employee;
	
	public TransferMoneyDTO(Account sourceAccountNum, Account targetAccountNum, double amount, String description,CurrencyType currency,Employee employee) {
		this.sourceAccountNum = sourceAccountNum;
		this.targetAccountNum = targetAccountNum;
		this.amount = amount;
		this.description = description;
		this.currency = currency;
		this.employee = employee;
	}
	
	public Account getSourceAccountNum() {
		return sourceAccountNum;
	}
	public void setSourceAccountNum(Account sourceAccountNum) {
		this.sourceAccountNum = sourceAccountNum;
	}
	public Account getTargetAccountNum() {
		return targetAccountNum;
	}
	public void setTargetAccountNum(Account targetAccountNum) {
		this.targetAccountNum = targetAccountNum;
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

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
