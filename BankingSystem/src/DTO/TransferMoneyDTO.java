package DTO;

import Model.Account;

public class TransferMoneyDTO {
	
	private Account sourceAccountNum;
	private Account targetAccountNum;
	private double amount;
	private String description;
	
	public TransferMoneyDTO(Account sourceAccountNum, Account targetAccountNum, double amount, String description) {
		this.sourceAccountNum = sourceAccountNum;
		this.targetAccountNum = targetAccountNum;
		this.amount = amount;
		this.description = description;
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
	
}
