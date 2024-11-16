package Service;

import DTO.EmployeeDTO;
import Model.Employee;

public class OTPService extends BaseService {
	
	private EmployeeDTO employee;
	private EmailSenderService emailSenderService;
	private static String sendOtp;
	
	public OTPService(EmployeeDTO employee) {
		this.employee = employee;
		this.emailSenderService = new EmailSenderService();
	}
	
	
	public void sentOTPmail() {
		sendOtp = Util.OTPUtil.generateOTP(5);
		this.emailSenderService.sendEmail(employee.getEmail(), "OTP mail",sendOtp);
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
