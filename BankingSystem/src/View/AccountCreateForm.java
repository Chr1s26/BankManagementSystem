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

public class AccountCreateForm extends BaseWindow {
	
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
	private JComboBox<Branch> branchCombo;
	
	private JLabel customerLabel;
	private JComboBox<Customer> customerCombo;

	private JButton createButton;
	private JButton cancelButton;
	
	private JPanel panel;
	private BranchDaoImpl branchDao;
	private CustomerDaoImpl customerDao;
	
	public AccountCreateForm() {
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
		
		customerLabel = new JLabel("Customer : ");
		customerCombo = new JComboBox<>(customerDao.getAll().toArray(new Customer[0]));
		
		createButton = new JButton("Create");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		
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
		panel.add(customerLabel);
		panel.add(customerCombo);
		panel.add(createButton);
		panel.add(cancelButton);
		
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

	public JComboBox<Branch> getBranchCombo() {
		return branchCombo;
	}

	public void setBranchCombo(JComboBox<Branch> branchCombo) {
		this.branchCombo = branchCombo;
	}

	public JLabel getCustomerLabel() {
		return customerLabel;
	}

	public void setCustomerLabel(JLabel customerLabel) {
		this.customerLabel = customerLabel;
	}

	public JComboBox<Customer> getCustomerCombo() {
		return customerCombo;
	}

	public void setCustomerCombo(JComboBox<Customer> customerCombo) {
		this.customerCombo = customerCombo;
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JLabel getConfirmpasswordLabel() {
		return confirmpasswordLabel;
	}

	public void setConfirmpasswordLabel(JLabel confirmpasswordLabel) {
		this.confirmpasswordLabel = confirmpasswordLabel;
	}

	public String getConfirmpasswordField() {
		return new String(confirmpasswordField.getPassword());
	}

	public void setConfirmpasswordField(JPasswordField confirmpasswordField) {
		this.confirmpasswordField = confirmpasswordField;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public String getPasswordField() {
		return new String(passwordField.getPassword());
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Account Create Form");
		this.setSize(800,400);
	}
}
