package Service;

import java.util.ArrayList;
import java.util.List;

import Converter.EmployeeMapper;
import DTO.EmployeeDTO;
import Dao.EmployeeDaoImpl;
import Model.Employee;

public class EmployeeUpdateService {
	
	private EmployeeDTO employeeDto;
	private EmployeeDaoImpl employeeDao;
	private List<String> errorMessages = new ArrayList<>();
 	
	public EmployeeUpdateService() {
		employeeDao = new EmployeeDaoImpl();
	}
	
	public void call(EmployeeDTO employeeDTO) throws Exception {
		this.errorMessages.clear();
		this.employeeDto = employeeDTO;
		this.checkEmailDuplication();
		this.checkPhoneDuplication();
		this.validatePassword();
		this.checkErrorMessage();
		this.updateProcess();
	}
	
	public void updateProcess() {
		Employee employee = EmployeeMapper.toEmployee(employeeDto);
		employeeDao.update(employee);
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
			errorMessages.add("Email is already in use.");
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