package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dao.BranchDaoImpl;
import Dao.CustomerDaoImpl;
import Model.AccountType;
import Model.Branch;
import Model.Customer;

public class AccountUpdateForm extends BaseWindow {
	
	private JLabel numberLabel;
	private JTextField numberField;
	
	private JLabel accountTypeLabel;
	private JComboBox<AccountType> accountTypeCombo;
	
	private JLabel balanceLabel;
	private JTextField balanceField;
	
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	private JLabel confirmpasswordLabel;
	private JPasswordField confirmpasswordField;
	
	private JLabel branchLabel;
	private JComboBox branchCombo;
	
	private JLabel customerLabel;
	private JComboBox customerCombo;

	private JButton updateButton;
	private JButton transactionButton;
	
	private JButton incomeButton;
	private JButton expenseButton;
	
	private JPanel panel;
	private BranchDaoImpl branchDao;
	private CustomerDaoImpl customerDao;
	
	public AccountUpdateForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		this.branchDao = new BranchDaoImpl();
		this.customerDao = new CustomerDaoImpl();
		
		numberLabel = new JLabel("Account Number : ");
		numberField = new JTextField();
		
		accountTypeLabel = new JLabel("Account Type : ");
		accountTypeCombo = new JComboBox<>(AccountType.values());
		
		balanceLabel = new JLabel("Balance : ");
		balanceField = new JTextField();
		
		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();
		
		confirmpasswordLabel = new JLabel("Confirm Password");
		confirmpasswordField = new JPasswordField();
		
		branchLabel = new JLabel("Branch : ");
		branchCombo = new JComboBox<>(branchDao.getAll().toArray(new Branch[0]));
		
		customerLabel = new JLabel("Account Holder Name : ");
		customerCombo = new JComboBox<>(customerDao.getAll().toArray(new Customer[0]));
		
		updateButton = new JButton("Update");
		transactionButton = new JButton("All Transaction");
		
		incomeButton = new JButton("Income");
		expenseButton = new JButton("Expense");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 2));
		
		panel.add(customerLabel);
		panel.add(customerCombo);
		panel.add(numberLabel);
		panel.add(numberField);
		panel.add(accountTypeLabel);
		panel.add(accountTypeCombo);
		panel.add(balanceLabel);
		panel.add(balanceField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(confirmpasswordLabel);
		panel.add(confirmpasswordField);
		panel.add(branchLabel);
		panel.add(branchCombo);
		panel.add(updateButton);
		panel.add(transactionButton);
		panel.add(incomeButton);
		panel.add(expenseButton);
		
		this.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();

	}
	
	public Branch getBranch() {
		Branch branch = (Branch)this.branchCombo.getSelectedItem();
		return branch;
	}
	
	public Customer getCustomer() {
		Customer customer = (Customer)this.customerCombo.getSelectedItem();
		return customer;
	}
	
	public AccountType getAccountType() {
		return (AccountType)this.accountTypeCombo.getSelectedItem();
	}
	
	public Customer getCustomerType() {
		return (Customer) this.customerCombo.getSelectedItem();
	}
	
	public Branch getBranchType() {
		return (Branch) this.branchCombo.getSelectedItem();
	}
	
	public JTextField getNumberField() {
		return numberField;
	}

	public void setNumberField(JTextField numberField) {
		this.numberField = numberField;
	}

	public JLabel getAccountTypeLabel() {
		return accountTypeLabel;
	}

	public void setAccountTypeLabel(JLabel accountTypeLabel) {
		this.accountTypeLabel = accountTypeLabel;
	}

	public JComboBox getAccountTypeCombo() {
		return accountTypeCombo;
	}

	public void setAccountTypeCombo(JComboBox accountTypeCombo) {
		this.accountTypeCombo = accountTypeCombo;
	}

	public JTextField getBalanceField() {
		return balanceField;
	}

	public void setBalanceField(JTextField balanceField) {
		this.balanceField = balanceField;
	}

	public JComboBox getBranchCombo() {
		return branchCombo;
	}

	public void setBranchCombo(JComboBox branchCombo) {
		this.branchCombo = branchCombo;
	}

	public JLabel getCustomerLabel() {
		return customerLabel;
	}

	public void setCustomerLabel(JLabel customerLabel) {
		this.customerLabel = customerLabel;
	}

	public JComboBox getCustomerCombo() {
		return customerCombo;
	}

	public void setCustomerCombo(JComboBox customerCombo) {
		this.customerCombo = customerCombo;
	}

	public JButton getupdateButton() {
		return updateButton;
	}

	public void setupdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getCancelButton() {
		return transactionButton;
	}

	public void setCancelButton(JButton transactionButton) {
		this.transactionButton = transactionButton;
	}
	
	public String getPasswordField() {
		return new String(passwordField.getPassword());
	}
	
	public String getConfirmpasswordField() {
		return new String(confirmpasswordField.getPassword());
	}

	public JButton getTransactionButton() {
		return transactionButton;
	}

	public void setTransactionButton(JButton transactionButton) {
		this.transactionButton = transactionButton;
	}

	public JButton getIncomeButton() {
		return incomeButton;
	}

	public void setIncomeButton(JButton incomeButton) {
		this.incomeButton = incomeButton;
	}

	public JButton getExpenseButton() {
		return expenseButton;
	}

	public void setExpenseButton(JButton expenseButton) {
		this.expenseButton = expenseButton;
	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Account History");
		this.setSize(800,400);
	}
}
