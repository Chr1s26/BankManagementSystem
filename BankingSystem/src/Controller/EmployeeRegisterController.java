package Controller;

import DTO.EmployeeDTO;
import Service.EmployeeCreateService;
import View.EmployeeRegisterForm;
import View.LoginWindow;

public class EmployeeRegisterController {
	
	private EmployeeRegisterForm view;
	private EmployeeCreateService createService;
	private LoginWindow loginWindow;
	private LoginController loginController;
	
	public EmployeeRegisterController(EmployeeRegisterForm view) {
		this.view = view;
		this.view.getCreateButton().addActionListener(e -> handleEmployeeRegisteration());
		this.createService = new EmployeeCreateService();
	}
	
	public void handleEmployeeRegisteration() {
		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setFirstName(this.view.getFirstName());
		employeeDto.setLastName(this.view.getLastName());
		employeeDto.setEmail(this.view.getEmail());
		employeeDto.setPassword(this.view.getPassword());
		employeeDto.setConfirmPassword(this.view.getConfirmPassword());
		employeeDto.setPhoneNumber(this.view.getPhoneNumber());
		employeeDto.setPosition(this.view.getPosition());
		employeeDto.setBranch(this.view.getBranchId());
		employeeDto.setSalary(this.view.getSalary());
		try {
		this.createService.call(employeeDto);
		this.view.showSuccessMessage("Employee Register successfully");
		this.view.dispose();
		this.loginWindow = new LoginWindow();
		this.loginController = new LoginController(loginWindow);
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
			this.view.dispose();
			EmployeeRegisterForm employeeRegisterForm= new EmployeeRegisterForm();
			EmployeeRegisterController employeeRegisterController = new EmployeeRegisterController(employeeRegisterForm);
		}
	}
}
