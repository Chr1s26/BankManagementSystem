package Controller;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DTO.EmployeeDTO;
import Dao.EmployeeDao;
import Dao.EmployeeDaoImpl;
import Model.Employee;
import Service.OTPService;
import View.OTP.OTPConfirmationForm;

public class OTPController extends BaseController {
	
	private OTPConfirmationForm view;
	private OTPService otpService;
	private EmployeeDTO employeeDTO;
	private EmployeeDao employeeDao;

	
	public OTPController(EmployeeDTO employee) {
		super(new OTPConfirmationForm());
		this.employeeDTO = employee;
		this.employeeDao = new EmployeeDaoImpl();
		initController();
	}
	
	@Override
	public void initController() {
		this.view = (OTPConfirmationForm) this.getView();
		this.view.getConfirmButton().addActionListener(e -> handleOTPConfirmBtn());
		this.view.getResentButton().addActionListener(e -> handleOTPResentBtn());
		otpService = new OTPService(this.employeeDTO);
	}
	
	
	public void sentOTP() {
		this.otpService.sentOTPmail();
	}

	
	private void handleOTPConfirmBtn() {
		try {
		this.otpService.validateOTP(this.view.getOtpField().getText());
		Employee employee = this.employeeDao.getEmployeeByEmployeeEmail(this.employeeDTO.getEmail());
		this.employeeDao.setConfimedAt(employee);
		this.view.getMessageLabel().setText("OTP Confirmed!. Access granted");
		this.view.getMessageLabel().setForeground(Color.GREEN);
		JOptionPane.showMessageDialog(view, "OTP confirmed ! Access granted");
		new BranchCreateController();
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
