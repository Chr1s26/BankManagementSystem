package Controller;

import DTO.EmployeeDTO;
import Model.Employee;
import View.EmployeeUpdateForm;

public class EmployeeUpdateController extends BaseController {
	
	private EmployeeUpdateForm view;
	
	public EmployeeUpdateController() {
		super(new EmployeeUpdateForm());
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (EmployeeUpdateForm) this.getView();
		this.view.getUpdateButton().addActionListener(e -> handleEmployeeUpdate());
	}

	private void handleEmployeeUpdate() {
		EmployeeDTO employeeDto = new EmployeeDTO();
		employeeDto.setFirstName(this.view.getFirstNameField().getText());
		employeeDto.setLastName(this.view.getLastNameField().getText());
		employeeDto.setEmail(this.view.getEmailField().getText());
		employeeDto.setPassword(this.view.getPasswordField());
		employeeDto.setConfirmPassword(this.view.getConfirmPasswordField());
		employeeDto.setPhoneNumber(this.view.getPhoneNumberField().getText());
		employeeDto.setPosition(this.view.getPositionComboBox());
		employeeDto.setBranch(this.view.getBranchComboBox());
		employeeDto.setSalary(this.view.getSalaryField().getText());
		try {
			
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
	
}
