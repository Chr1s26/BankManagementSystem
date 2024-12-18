package Controller;

import DTO.EmployeeDTO;
import Dao.EmployeeDaoImpl;
import Model.Employee;
import Service.EmployeeUpdateService;
import View.EmployeeUpdateForm;

public class EmployeeUpdateController extends BaseController {
	
	private EmployeeUpdateForm view;
	private EmployeeListingController parentController;
	private Employee employee;
	private EmployeeDaoImpl employeeDao;
	private EmployeeUpdateService updateService;
	
	public EmployeeUpdateController(EmployeeListingController parentController,int employeeId) {
		super(new EmployeeUpdateForm());
		this.parentController = parentController;
		this.employeeDao = new EmployeeDaoImpl();
		this.employee = employeeDao.getById(employeeId);
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (EmployeeUpdateForm) this.getView();
		this.updateService = new EmployeeUpdateService();
		
		this.view.getFirstNameField().setText(employee.getfirstName());
		this.view.getLastNameField().setText(employee.getlastName());
		this.view.getEmailField().setText(employee.getEmail());
		this.view.getPhoneNumberField().setText(employee.getPhoneNumber());
		this.view.setPositionComboBox(employee.getPosition());
		this.view.setBranchComboBox(employee.getBranch().getName());
		this.view.getFirstNameField().setText(employee.getfirstName());
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
		employeeDto.setId(employee.getId());
		try {
			this.updateService.calls(employeeDto);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Employee Updated successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
	
}
