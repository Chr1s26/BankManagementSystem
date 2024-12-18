package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import Dao.CustomerDaoImpl;
import Dao.LoanDaoImpl;
import Model.Customer;
import Model.LoanType;
import Util.DateLabelFormatter;

public class LoanUpdateForm extends BaseWindow {
	
	private JLabel loanAmount;
	private JTextField loanAmountField;
	
	private JLabel interestRateLabel;
	private JTextField interestRateField;
	
	private JLabel loanStartDateLabel;
	private SqlDateModel loanStartModel;
	private JDatePanelImpl loanStartPanel;
	private JDatePickerImpl loanStartPicker;
	
	private JLabel loanEndDateLabel;
	private SqlDateModel loanEndModel;
	private JDatePanelImpl loanEndPanel;
	private JDatePickerImpl loanEndPicker;
	
	private JLabel customerLabel;
	private JComboBox<Customer> customerComboBoxField;
	
	private JLabel loanTypeLabel;
	private JComboBox<LoanType> loanComboBoxField;
	
	private JButton updateButton;
	private JButton cancelButton;
	
	private JPanel panel;
	private LoanDaoImpl loanDao;
	private CustomerDaoImpl customerDao;
	
	public LoanUpdateForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		loanDao = new LoanDaoImpl();
		customerDao = new CustomerDaoImpl();
		
		loanAmount = new JLabel("Loan Amount : ");
		loanAmountField = new JTextField();
		
		interestRateLabel = new JLabel("Interest Rate : ");
		interestRateField = new JTextField();
		
		loanStartDateLabel = new JLabel("Loan Start Date : ");
		this.loanStartModel = new SqlDateModel();
		this.loanStartPanel = new JDatePanelImpl(loanStartModel,new Properties());
		this.loanStartPicker = new JDatePickerImpl(loanStartPanel,new DateLabelFormatter());
	
		
		loanEndDateLabel = new JLabel("Loan End Date : ");
		this.loanEndModel = new SqlDateModel();
		this.loanEndPanel = new JDatePanelImpl(loanEndModel,new Properties());
		this.loanEndPicker = new JDatePickerImpl(loanEndPanel,new DateLabelFormatter());
		
		customerLabel = new JLabel("Customer : ");
		customerComboBoxField = new JComboBox<>(customerDao.getAll().toArray(new Customer[0]));
		
		loanTypeLabel = new JLabel("Loan Type : ");
		loanComboBoxField = new JComboBox<>(LoanType.values());
		
		updateButton = new JButton("Update");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));
		
		panel.add(loanAmount);
		panel.add(loanAmountField);
		panel.add(interestRateLabel);
		panel.add(interestRateField);
		panel.add(loanStartDateLabel);
		panel.add(loanStartPicker);
		panel.add(loanEndDateLabel);
		panel.add(loanEndPicker);
		panel.add(customerLabel);
		panel.add(customerComboBoxField);
		panel.add(loanTypeLabel);
		panel.add(loanComboBoxField);
		panel.add(updateButton);
		panel.add(cancelButton);
		
		this.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();
		
	}

	public JTextField getLoanAmountField() {
		return loanAmountField;
	}

	public void setLoanAmountField(JTextField loanAmountField) {
		this.loanAmountField = loanAmountField;
	}

	public JTextField getInterestRateField() {
		return interestRateField;
	}

	public void setInterestRateField(JTextField interestRateField) {
		this.interestRateField = interestRateField;
	}

	public SqlDateModel getLoanStartModel() {
		return loanStartModel;
	}

	public void setLoanStartModel(SqlDateModel loanStartModel) {
		this.loanStartModel = loanStartModel;
	}

	public JDatePanelImpl getLoanStartPanel() {
		return loanStartPanel;
	}

	public void setLoanStartPanel(JDatePanelImpl loanStartPanel) {
		this.loanStartPanel = loanStartPanel;
	}

	public JDatePickerImpl getLoanStartPicker() {
		return loanStartPicker;
	}

	public void setLoanStartPicker(JDatePickerImpl loanStartPicker) {
		this.loanStartPicker = loanStartPicker;
	}

	public SqlDateModel getLoanEndModel() {
		return loanEndModel;
	}

	public void setLoanEndModel(SqlDateModel loanEndModel) {
		this.loanEndModel = loanEndModel;
	}

	public JDatePanelImpl getLoanEndPanel() {
		return loanEndPanel;
	}

	public void setLoanEndPanel(JDatePanelImpl loanEndPanel) {
		this.loanEndPanel = loanEndPanel;
	}

	public JDatePickerImpl getLoanEndPicker() {
		return loanEndPicker;
	}

	public void setLoanEndPicker(JDatePickerImpl loanEndPicker) {
		this.loanEndPicker = loanEndPicker;
	}

	public JComboBox<Customer> getCustomerComboBoxField() {
		return customerComboBoxField;
	}
	
	public Customer getCustomer() {
		Customer customer = (Customer)this.customerComboBoxField.getSelectedItem();
		return customer;
	}

	public void setCustomerComboBoxField(JComboBox<Customer> customerComboBoxField) {
		this.customerComboBoxField = customerComboBoxField;
	}

	public JComboBox<LoanType> getLoanComboBoxField() {
		return loanComboBoxField;
	}
	
	public LoanType getLoanType() {
		return (LoanType)this.loanComboBoxField.getSelectedItem();
	}

	public void setLoanComboBoxField(JComboBox<LoanType> loanComboBoxField) {
		this.loanComboBoxField = loanComboBoxField;
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

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Loan Update Form");
		this.setSize(800,400);
		
	}
}
