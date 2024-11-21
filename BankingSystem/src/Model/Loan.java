package Model;

import java.sql.Date;

public class Loan {
	
	private int id;
	private String loanType;
	private double loanAmount;
	private double interestRate;
	private Date loanStartDate;
	private Date loanEndDate;
	private Customer customer;
	
	public Loan() {
		
	}
	
	public Loan(int id, String loanType, double loanAmount, double interestRate, Date loanStartDate,
			Date loanEndDate, Customer customer) {
		
		this.id = id;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
		this.customer = customer;
	}
	
	public Loan(int id, String loanType, double loanAmount, double interestRate, Date loanStartDate,
			Date loanEndDate) {
		
		this.id = id;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getloanType() {
		return loanType;
	}

	public void setloanType(String loanType) {
		this.loanType = loanType;
	}

	public double getloanAmount() {
		return loanAmount;
	}

	public void setloanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getinterestRate() {
		return interestRate;
	}

	public void setinterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getloanStartDate() {
		return loanStartDate;
	}

	public void setloanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Date getloanEndDate() {
		return loanEndDate;
	}

	public void setloanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", interestRate="
				+ interestRate + ", loanStartDate=" + loanStartDate + ", loanEndDate=" + loanEndDate
				+ ", customer=" + customer + "]";
	}

	
}
