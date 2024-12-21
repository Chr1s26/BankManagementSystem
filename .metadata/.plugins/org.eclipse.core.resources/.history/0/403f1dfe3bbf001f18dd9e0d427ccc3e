package Controller;

import DTO.EmployeeDTO;
import Service.EmployeeCreateService;
import View.EmployeeRegisterForm;
import View.LoginWindow;

public class EmployeeRegisterController extends BaseController {
	
	private EmployeeRegisterForm view ;
	private EmployeeCreateService createService;
	private EmployeeListingController parentController;
	
	public EmployeeRegisterController(EmployeeListingController parentController) {
		super(new EmployeeRegisterForm());
		this.parentController = parentController;
		this.authenticate();
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
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Employee Register successfully");
			this.view.dispose();
			new OTPController(employeeDto);
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initController() {
		this.view = (EmployeeRegisterForm) this.getView();
		this.view.getCreateButton().addActionListener(e -> handleEmployeeRegisteration());
		this.createService = new EmployeeCreateService();
	}
}
