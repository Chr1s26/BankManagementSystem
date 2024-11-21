package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HomeView extends BaseWindow {
	
	private JMenuBar homeMenu;
	
	private JMenu employeeMenu;
	private JMenuItem employeeListing;
	
	private JMenu branchMenu;
	private JMenuItem branchListing;
	
	private JMenu customerMenu;
	private JMenuItem customerListing;
	
	private JMenu accountMenu;
	private JMenuItem accountListing;
	
	private JMenu loanMenu;
	private JMenuItem loanListing;
	
	private JMenu transactionMenu;
	private JMenuItem transactionListing;
	private JMenuItem transferMoney;
	
	private JMenu cardMenu;
	private JMenuItem cardListing;
	
	private JMenu cardTransactionMenu;
	private JMenuItem cardTransactionListing;
	

	
	public HomeView() {
		this.initializeComponent();
	}
	
	public void initializeComponent() {
		
		this.homeMenu = new JMenuBar();
		this.employeeMenu = new JMenu("Employee");
		this.employeeListing = new JMenuItem("Employee Listing");
		this.branchMenu = new JMenu("Branch");
		this.branchListing = new JMenuItem("Branch Listing");
		this.customerMenu = new JMenu("Customer");
		this.customerListing = new JMenuItem("Customer Listing");
		this.accountMenu = new JMenu("Account");
		this.accountListing = new JMenuItem("Account Listing");
		this.loanMenu = new JMenu("Loan");
		this.loanListing = new JMenuItem("Loan Listing");
		this.transactionMenu = new JMenu("Transaction");
		this.transactionListing = new JMenuItem("Transaction Listing");
		this.transferMoney = new JMenuItem("Transfer Money");
		this.cardMenu = new JMenu("Card");
		this.cardListing = new JMenuItem("Card Listing");
		this.cardTransactionMenu = new JMenu("Card Transaction");
		this.cardTransactionListing = new JMenuItem("Card Transaction Listing");
		
		this.homeMenu.add(employeeMenu);
		this.homeMenu.add(customerMenu);
		this.homeMenu.add(branchMenu);
		this.homeMenu.add(accountMenu);
		this.homeMenu.add(loanMenu);
		this.homeMenu.add(cardMenu);
		this.homeMenu.add(transactionMenu);
		this.homeMenu.add(cardTransactionMenu);
		
		this.employeeMenu.add(employeeListing);
		this.customerMenu.add(customerListing);
		this.branchMenu.add(branchListing);
		this.accountMenu.add(accountListing);
		this.loanMenu.add(loanListing);
		this.cardMenu.add(cardListing);
		this.transactionMenu.add(transactionListing);
		this.transactionMenu.add(this.transferMoney);
		this.cardTransactionMenu.add(cardTransactionListing);
		
		this.setJMenuBar(this.homeMenu);
		this.setTitle("HomeView");
	}
	
	public JMenuItem getEmployeeListing() {
		return employeeListing;
	}

	public void setEmployeeListing(JMenuItem employeeListing) {
		this.employeeListing = employeeListing;
	}

	public JMenuItem getBranchListing() {
		return branchListing;
	}

	public void setBranchListing(JMenuItem branchListing) {
		this.branchListing = branchListing;
	}

	public JMenuItem getCustomerListing() {
		return customerListing;
	}

	public void setCustomerListing(JMenuItem customerListing) {
		this.customerListing = customerListing;
	}

	public JMenuItem getAccountListing() {
		return accountListing;
	}

	public void setAccountListing(JMenuItem accountListing) {
		this.accountListing = accountListing;
	}

	public JMenuItem getLoanListing() {
		return loanListing;
	}

	public void setLoanListing(JMenuItem loanListing) {
		this.loanListing = loanListing;
	}

	public JMenuItem getTransactionListing() {
		return transactionListing;
	}

	public void setTransactionListing(JMenuItem transactionListing) {
		this.transactionListing = transactionListing;
	}

	public JMenuItem getCardListing() {
		return cardListing;
	}

	public void setCardListing(JMenuItem cardListing) {
		this.cardListing = cardListing;
	}

	public JMenuItem getCardTransactionListing() {
		return cardTransactionListing;
	}

	public void setCardTransactionListing(JMenuItem cardTransactionListing) {
		this.cardTransactionListing = cardTransactionListing;
	}

	public JMenu getTransactionMenu() {
		return transactionMenu;
	}

	public void setTransactionMenu(JMenu transactionMenu) {
		this.transactionMenu = transactionMenu;
	}

	public JMenuItem getTransferMoney() {
		return transferMoney;
	}

	public void setTransferMoney(JMenuItem transferMoney) {
		this.transferMoney = transferMoney;
	}
	
}
