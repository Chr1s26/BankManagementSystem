package DTO;

import Model.Card;
import Model.CurrencyType;
import Model.Employee;

public class CardTransferMoneyDTO {
	
	private Card sourceCardNum;
	private Card targetCardNum;
	private double amount;
	private String description;
	private CurrencyType currency;
	private Employee employee;
	
	public CardTransferMoneyDTO(Card sourceCardNum, Card targetCardNum, double amount, String description,CurrencyType currency,Employee employee) {
		this.sourceCardNum = sourceCardNum;
		this.targetCardNum = targetCardNum;
		this.amount = amount;
		this.description = description;
		this.currency = currency;
		this.employee = employee;
	}

	public Card getSourceCardNum() {
		return sourceCardNum;
	}

	public void setSourceCardNum(Card sourceCardNum) {
		this.sourceCardNum = sourceCardNum;
	}

	public Card getTargetCardNum() {
		return targetCardNum;
	}

	public void setTargetCardNum(Card targetCardNum) {
		this.targetCardNum = targetCardNum;
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
