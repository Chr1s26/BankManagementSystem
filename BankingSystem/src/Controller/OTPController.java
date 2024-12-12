package Controller;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import Dao.AccountDaoImpl;
import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import Dao.TransactionDaoImpl;
import Model.Customer;
import Model.Employee;
import Model.Transaction;
import Service.OTPService;
import View.OTP.OTPConfirmationForm;

public class OTPController extends BaseController {
	
	private OTPConfirmationForm view;
	private OTPService otpService;
	private EmployeeDTO employeeDTO;
	private EmployeeDao employeeDao;
	
	private CustomerDTO customerDTO;
	private TransactionDaoImpl transactionDao;
	private Transaction transaction;
	
	private AccountDTO accountDTO;
	private AccountDaoImpl accountDao;
	
	
	public OTPController(CustomerDTO customer,Transaction transaction) {
		super(new OTPConfirmationForm());
		this.customerDTO = customer;
		this.transactionDao = new TransactionDaoImpl();
		this.transaction = transaction;
		customerOTPController();
	}
	
	public OTPController(EmployeeDTO employee) {
		super(new OTPConfirmationForm());
		this.employeeDTO = employee;
		this.employeeDao = new EmployeeDaoImpl();
		initController();
	}
	
	public OTPController(AccountDTO account) {
		super(new OTPConfirmationForm());
		this.accountDTO = account;
		this.accountDao = new AccountDaoImpl();
		AccountOTPController();
	}
	
	public void AccountOTPController() {
		this.view = (OTPConfirmationForm) this.getView();
		this.view.getConfirmButton().addActionListener(e -> handleOTPConfirmBtnForAccount());
		this.view.getResentButton().addActionListener(e -> handleOTPResentBtn());
		otpService = new OTPService(this.accountDTO.getCustomer().getEmail(),"Account OTP Confirmation");
	}
	
	public void customerOTPController() {
		this.view = (OTPConfirmationForm) this.getView();
		System.out.print("Customer email "+this.customerDTO.getEmail());
		this.view.getConfirmButton().addActionListener(e -> handleOTPConfirmBtnForCustomer());
		this.view.getResentButton().addActionListener(e -> handleOTPResentBtn());
		otpService = new OTPService(this.customerDTO.getEmail(),"Customer OTP Confirmation");
		
	}
	
	@Override
	public void initController() {
		this.view = (OTPConfirmationForm) this.getView();
		this.view.getConfirmButton().addActionListener(e -> handleOTPConfirmBtn());
		this.view.getResentButton().addActionListener(e -> handleOTPResentBtn());
		otpService = new OTPService(this.employeeDTO.getEmail(),"Employee OTP Confirmation");
	}
	
	public void sentOTP() {
		this.otpService.sentOTPmail();
	}
	
	private void handleOTPConfirmBtnForCustomer() {
		try {
		this.otpService.validateOTP(this.view.getOtpField().getText());
		this.transactionDao.setConfirmedAt(transaction);
		this.view.getMessageLabel().setText("OTP Confirmed!. Access granted");
		this.view.getMessageLabel().setForeground(Color.GREEN);
		JOptionPane.showMessageDialog(view, "OTP confirmed ! Access granted  And Money Transfer Successfully");
		this.view.dispose();
		}
		catch(Exception e) {
			this.view.getMessageLabel().setText("Invalid OTP. Please Try Again !!");
			this.view.getMessageLabel().setForeground(Color.RED);
		}
	}
	
	public void handleOTPConfirmBtnForAccount() {
		try {
		this.otpService.validateOTP(this.view.getOtpField().getText());
		this.view.getMessageLabel().setText("OTP Confirmed!. Access granted");
		this.view.getMessageLabel().setForeground(Color.GREEN);
		JOptionPane.showMessageDialog(view, "OTP confirmed ! Access granted  And Money Transfer Successfully");
		this.view.dispose();
		}
		catch(Exception e) {
			this.view.getMessageLabel().setText("Invalid OTP. Please Try Again !!");
			this.view.getMessageLabel().setForeground(Color.RED);
		}
	}

	
	private void handleOTPConfirmBtn() {
		try {
		this.otpService.validateOTP(this.view.getOtpField().getText());
		Employee employee = this.employeeDao.getEmployeeByEmployeeEmail(this.employeeDTO.getEmail());
		this.employeeDao.setConfimedAt(employee);
		this.view.getMessageLabel().setText("OTP Confirmed!. Access granted");
		this.view.getMessageLabel().setForeground(Color.GREEN);
		JOptionPane.showMessageDialog(view, "OTP confirmed ! Access granted");
		homeViewController home = new homeViewController();
		}
		catch(Exception e) {
			this.view.getMessageLabel().setText("Invalid OTP. Please Try Again !!");
			this.view.getMessageLabel().setForeground(Color.RED);
		}
	}
	
	private void handleOTPResentBtn() {
		this.otpService.sentOTPmail();

	}

}
