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
		this.employeeDao = new EmployeeDaoImpl();
	}	
	 
	public void calls(EmployeeDTO employeeDto) throws Exception {
		this.errorMessages.clear();
		this.employeeDto = employeeDto;
		this.validatePassword();
		this.checkErrorMessage();
		this.updateProcess();
	}

	private void updateProcess() {
		Employee employee = EmployeeMapper.toEmployee(this.employeeDto);
		System.out.print(employee.getId());
		employeeDao.update(employee);
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
