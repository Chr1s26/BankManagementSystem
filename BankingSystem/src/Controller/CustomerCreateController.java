package Controller;

import java.sql.Date;

import DTO.CustomerDTO;
import Service.CustomerCreateService;
import Util.DateConverter;
import Util.DateUtil;
import View.CustomerCreateForm;

public class CustomerCreateController extends BaseController {
	
	private CustomerCreateForm view ;
	private CustomerCreateService createService;
	private CustomerListingController parentController;
	
	public CustomerCreateController(CustomerListingController parentController) {
		super(new CustomerCreateForm());
		this.parentController = parentController;
		this.authenticate();
	}
	
	public void handleCustomerRegisteration() {
		CustomerDTO CustomerDTO = new CustomerDTO();
		CustomerDTO.setFirstName(this.view.getFirstName());
		CustomerDTO.setLastName(this.view.getLastName());
		CustomerDTO.setEmail(this.view.getEmail());
		CustomerDTO.setPhoneNumber(this.view.getPhoneNumber());
		CustomerDTO.setAddress(this.view.getAddressField().getText());
		Date date = (Date) this.view.getDatePanel().getModel().getValue();
		CustomerDTO.setDateOfBirth(date);
		try {
			this.createService.call(CustomerDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Customer Register successfully");
			this.view.dispose();
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initController() {
		this.view = (CustomerCreateForm) this.getView();
		this.view.getCreateButton().addActionListener(e -> handleCustomerRegisteration());
		this.createService = new CustomerCreateService();
	}
}
