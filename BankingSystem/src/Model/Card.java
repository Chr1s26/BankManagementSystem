package Model;

import java.sql.Date;

public class Card {
	
	private int id;
	private String cardNumber;
	private CardType cardType;
	private Date expireDate;
	private int securityCode;
	private Customer customer;
	private Account account;
	
	public Card() {
		
	}
	
	public Card(int id, String cardNumber, CardType cardType, Date expireDate, int securityCode, Customer customer,
			Account account) {
		
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expireDate = expireDate;
		this.securityCode = securityCode;
		this.customer = customer;
		this.account = account;
	}
	
	public Card(int id, String cardNumber, CardType cardType, Date expireDate, int securityCode) {
		
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expireDate = expireDate;
		this.securityCode = securityCode;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return this.cardNumber;
	}
	
	
}
