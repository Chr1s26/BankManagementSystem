package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dao.BranchDaoImpl;
import Dao.CustomerDaoImpl;
import Model.Branch;
import Model.Customer;

public class AccountUpdateForm extends BaseWindow {
	
	private JLabel numberLabel;
	private JTextField numberField;
	
	private JLabel accountTypeLabel;
	private JComboBox accountTypeCombo;
	
	private JLabel balanceLabel;
	private JTextField balanceField;
	
	private JLabel branchLabel;
	private JComboBox branchCombo;
	
	private JLabel customerLabel;
	private JComboBox customerCombo;

	private JButton createButton;
	private JButton cancelButton;
	
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
		accountTypeCombo = new JComboBox<>(new String[] {"Saving", "Loan", "Investment"});
		
		balanceLabel = new JLabel("Balance : ");
		balanceField = new JTextField();
		
		branchLabel = new JLabel("Branch : ");
		branchCombo = new JComboBox<>(branchDao.getAll().toArray(new Branch[0]));
		
		customerLabel = new JLabel("Customer : ");
		customerCombo = new JComboBox<>(customerDao.getAll().toArray(new Customer[0]));
		
		createButton = new JButton("Create");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		
		panel.add(numberLabel);
		panel.add(numberField);
		panel.add(accountTypeLabel);
		panel.add(accountTypeCombo);
		panel.add(balanceLabel);
		panel.add(balanceField);
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
	
	public String getAccountType() {
		return (String)this.accountTypeCombo.getSelectedItem();
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

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Account Update Form");
		this.setSize(800,400);
	}
}
