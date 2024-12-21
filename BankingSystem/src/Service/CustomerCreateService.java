package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Converter.CustomerMapper;
import DTO.CustomerDTO;
import Dao.CustomerDaoImpl;
import Model.Customer;
import Model.Employee;

public class CustomerCreateService {
	
	private CustomerDTO CustomerDTO;
	private CustomerDaoImpl CustomerDao;

	
	public CustomerCreateService() {
		this.CustomerDao = new CustomerDaoImpl();
	}	
	 
	public void call(CustomerDTO CustomerDTO) throws Exception {
		this.CustomerDTO = CustomerDTO;

		this.creationProcess();
	}

	private void creationProcess() throws SQLException {
		Customer customer = CustomerMapper.toCustomer(this.CustomerDTO);
		Employee createdBy = AuthenticationService.employee;
		customer.setcreatedBy(createdBy);
		CustomerDao.create(customer);
	}
}
