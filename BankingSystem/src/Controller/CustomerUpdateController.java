package Controller;

import java.sql.Date;

import DTO.CustomerDTO;
import Dao.CustomerDaoImpl;
import Model.Customer;
import Service.CustomerUpdateService;
import Util.DateConverter;
import Util.DateUtil;
import View.CustomerUpdateForm;

public class CustomerUpdateController extends BaseController {
	
	private CustomerUpdateForm view ;
	private CustomerUpdateService updateService;
	private CustomerListingController parentController;
	private CustomerDaoImpl customerDao;
	private Customer customer;
	
	public CustomerUpdateController(CustomerListingController parentController,int Customerid) {
		super(new CustomerUpdateForm());
		this.parentController = parentController;
		this.customerDao = new CustomerDaoImpl();
		this.customer = customerDao.getById(Customerid);
		this.authenticate();
	}
	
	public void handleCustomerUpdate() {
		CustomerDTO CustomerDTO = new CustomerDTO();
		CustomerDTO.setFirstName(this.view.getFirstName());
		CustomerDTO.setLastName(this.view.getLastName());
		CustomerDTO.setEmail(this.view.getEmail());
		CustomerDTO.setPhoneNumber(this.view.getPhoneNumber());
		CustomerDTO.setAddress(this.view.getAddressField().getText());
		CustomerDTO.setDateOfBirth((Date)this.view.getDatePanel().getModel().getValue());
		CustomerDTO.setId(this.customer.getId());
		try {
			this.updateService.call(CustomerDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Customer Update successfully");
			this.view.dispose();
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initController() {
		this.view = (CustomerUpdateForm) this.getView();
		this.view.getFirstNameField().setText(this.customer.getfirstName());
		this.view.getLastNameField().setText(this.customer.getlastName());
		this.view.getEmailField().setText(this.customer.getEmail());
		this.view.getPhoneNumberField().setText(this.customer.getPhoneNumber());
		this.view.getAddressField().setText(this.customer.getAddress());
		this.view.getupdateButton().addActionListener(e -> handleCustomerUpdate());
		this.updateService = new CustomerUpdateService();
	}
}
