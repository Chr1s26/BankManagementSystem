package Service;

import java.util.ArrayList;
import java.util.List;

import Converter.CustomerMapper;
import DTO.CustomerDTO;
import Dao.CustomerDaoImpl;
import Model.Customer;

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

	private void creationProcess() {
		Customer Customer = CustomerMapper.toCustomer(this.CustomerDTO);
		CustomerDao.create(Customer);
	}
}
