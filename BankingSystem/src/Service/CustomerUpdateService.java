package Service;

import Converter.CustomerMapper;
import DTO.CustomerDTO;
import Dao.CustomerDaoImpl;
import Model.Customer;

public class CustomerUpdateService {
	
	private CustomerDTO CustomerDTO;
	private CustomerDaoImpl CustomerDao;

	
	public CustomerUpdateService() {
		this.CustomerDao = new CustomerDaoImpl();
	}	
	 
	public void call(CustomerDTO CustomerDTO) throws Exception {
		this.CustomerDTO = CustomerDTO;
		this.updateProcess();
	}

	private void updateProcess() {
		Customer Customer = CustomerMapper.toCustomer(this.CustomerDTO);
		CustomerDao.update(Customer);
	}
}
