package Service;

import DTO.CustomerDTO;
import DTO.EmployeeDTO;
import Model.Employee;
 	
public class OTPService extends BaseService {
	
	private EmployeeDTO employee;
	private EmailSenderService emailSenderService;
	public static String sendOtp;
	
	public OTPService(EmployeeDTO employee) {
		this.emailSenderService = new EmailSenderService(employee.getEmail(),"OTP mail",sendOtp);
		this.employee = employee;
	}
	
	public OTPService(CustomerDTO customer) {
		this.emailSenderService = new EmailSenderService(customer.getEmail(),"OTP mail",sendOtp);
	}
	
	public void sentOTPmail() {
		this.emailSenderService.setName("OTP thread");
		this.emailSenderService.start();
	}
	
	public void validateOTP(String otp) throws Exception {
		if(otp.equals(sendOtp)) {
			System.out.print("Otp validation success !!!");
		}
		else {
			System.out.print("Otp validation fail !!! ");
			throw new Exception("Otp validation fail !!! ");
		}
	}
}
