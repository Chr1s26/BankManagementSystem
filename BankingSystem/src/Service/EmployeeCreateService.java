package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Converter.EmployeeMapper;
import DTO.EmployeeDTO;
import Dao.EmployeeDaoImpl;
import Model.Employee;

public class EmployeeCreateService {
	
	private EmployeeDTO employeeDto;
	private EmployeeDaoImpl employeeDao;
	private List<String> errorMessages = new ArrayList<>();
	private OTPService optService;
	
	public EmployeeCreateService() {
		this.employeeDao = new EmployeeDaoImpl();
	}	
	 
	public void call(EmployeeDTO employeeDto) throws Exception {
		this.errorMessages.clear();
		this.employeeDto = employeeDto;
		this.validatePassword();
		this.checkEmailDuplication();
		this.checkPhoneDuplication();
		this.checkErrorMessage();
		this.creationProcess();
		this.optService = new OTPService(employeeDto.getEmail(),"Employee Create Confirmation");
		this.optService.sentOTPmail();
	}

	private void creationProcess() throws SQLException {
		Employee employee = EmployeeMapper.toEmployee(this.employeeDto);
		employeeDao.create(employee);
	}

	private void checkPhoneDuplication() {
		String phone = employeeDto.getPhoneNumber();
		if(employeeDao.isPhoneExists(phone)) {
			errorMessages.add("Phone number is already in use.");
		}
	}

	private void checkEmailDuplication() {
		String email = employeeDto.getEmail();
		if(employeeDao.isEmailExists(email)) {
			errorMessages.add("Emailed is already in use.");
		}
	} 

	private void checkErrorMessage() throws Exception {
		if(!errorMessages.isEmpty()) {
			throw new Exception(errorMessages.toString().concat("\n")); 
		}
	}

	private void validatePassword() {
		if(!this.employeeDto.getPassword().equals(this.employeeDto.getConfirmPassword())) {
			this.errorMessages.add("Incorrect Passowrd!!");
		}
	}

}
