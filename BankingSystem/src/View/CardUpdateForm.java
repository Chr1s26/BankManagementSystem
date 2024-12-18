package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import Dao.AccountDaoImpl;
import Dao.CustomerDaoImpl;
import Model.Account;
import Model.CardType;
import Model.Customer;
import Util.DateLabelFormatter;

public class CardUpdateForm extends BaseWindow {
	
	private JLabel cardNumberLabel;
	private JTextField cardNumberField;
	
	private JLabel cardTypeLabel;
	private JComboBox<CardType> cardTypeField;
	
	private JLabel expireDateLabel;
	private SqlDateModel expireModel;
	private JDatePanelImpl expirePanel;
	private JDatePickerImpl expirePicker;
	
	private JLabel securityLabel;
	private JTextField securityField;
	
	private JLabel customerLabel;
	private JComboBox<Customer> customerField;
	
	private JLabel accountLabel;
	private JComboBox<Account> accountField;
	
	private JButton updateButton;
	private JButton cancelButton;
	
	private JButton incomeButton;
	private JButton expenseButton;
	
	private JPanel panel;
	private CustomerDaoImpl customerDao;
	private AccountDaoImpl accountDao;
	
	public CardUpdateForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		customerDao = new CustomerDaoImpl();
		accountDao = new AccountDaoImpl();
		
		cardNumberLabel = new JLabel("Card Number : ");
		cardNumberField = new JTextField();
		
		cardTypeLabel = new JLabel("Card Type : ");
		cardTypeField = new JComboBox(CardType.values());
		
		expireDateLabel = new JLabel("Expire Date : ");
		this.expireModel = new SqlDateModel();
		this.expirePanel = new JDatePanelImpl(expireModel,new Properties());
		this.expirePicker = new JDatePickerImpl(expirePanel,new DateLabelFormatter());
		
		securityLabel = new JLabel("Security Code : ");
		securityField = new JTextField();
		
		customerLabel = new JLabel("Customer : ");
		customerField = new JComboBox(customerDao.getAll().toArray(new Customer[0]));
		
		accountLabel = new JLabel("Account : ");
		accountField = new JComboBox(accountDao.getAll().toArray(new Account[0]));
		
		updateButton = new JButton("Update");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		
		panel.add(cardNumberLabel);
		panel.add(cardNumberField);
		panel.add(cardTypeLabel);
		panel.add(cardTypeField);
		panel.add(expireDateLabel);
		panel.add(expirePicker);
		panel.add(securityLabel);
		panel.add(securityField);
		panel.add(customerLabel);
		panel.add(customerField);
		panel.add(accountLabel);
		panel.add(accountField);
		panel.add(updateButton);
		panel.add(cancelButton);
		panel.add(incomeButton);
		panel.add(expenseButton);
		
		this.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();
		
	}
	
	public JSpinner createTimeSpinner() {
		SpinnerDateModel timeModel = new SpinnerDateModel(new Date(),null,null,Calendar.HOUR_OF_DAY);
		JSpinner timeSpinner = new JSpinner(timeModel);
		JSpinner.DateEditor timeEditer = new JSpinner.DateEditor(timeSpinner,"HH:mm");
		timeSpinner.setEditor(timeEditer);
		
		Dimension spinnerSize = new Dimension(10,10);
		timeSpinner.setPreferredSize(spinnerSize);
		return timeSpinner;
	}

	public JTextField getCardNumberField() {
		return cardNumberField;
	}

	public void setCardNumberField(JTextField cardNumberField) {
		this.cardNumberField = cardNumberField;
	}

	public JComboBox<CardType> getCardTypeField() {
		return cardTypeField;
	}
	
	public CardType getCardType() {
		return (CardType)this.cardTypeField.getSelectedItem();
	}
	
	public Customer getCustomer() {
		Customer customer = (Customer)this.customerField.getSelectedItem();
		return customer;
	}
	
	public Account getAccount() {
		Account account = (Account)this.accountField.getSelectedItem();
		return account;
	}

	public void setCardTypeField(JComboBox<CardType> cardTypeField) {
		this.cardTypeField = cardTypeField;
	}

	public SqlDateModel getExpireModel() {
		return expireModel;
	}

	public void setExpireModel(SqlDateModel expireModel) {
		this.expireModel = expireModel;
	}

	public JDatePanelImpl getExpirePanel() {
		return expirePanel;
	}

	public void setExpirePanel(JDatePanelImpl expirePanel) {
		this.expirePanel = expirePanel;
	}

	public JDatePickerImpl getExpirePicker() {
		return expirePicker;
	}

	public void setExpirePicker(JDatePickerImpl expirePicker) {
		this.expirePicker = expirePicker;
	}

	public JTextField getSecurityField() {
		return securityField;
	}

	public void setSecurityField(JTextField securityField) {
		this.securityField = securityField;
	}

	public JComboBox<Customer> getCustomerField() {
		return customerField;
	}

	public void setCustomerField(JComboBox<Customer> customerField) {
		this.customerField = customerField;
	}

	public JComboBox<Account> getAccountField() {
		return accountField;
	}

	public void setAccountField(JComboBox<Account> accountField) {
		this.accountField = accountField;
	}

	public JButton getupdateButton() {
		return updateButton;
	}

	public void setupdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
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

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Card Create Form");
		this.setSize(800,400);
		
	}
}
