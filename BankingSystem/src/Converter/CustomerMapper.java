package Converter;

import java.sql.Date;

import DTO.CustomerDTO;
import Dao.CustomerDaoImpl;
import Model.Customer;

public class CustomerMapper {
	
	public static CustomerDaoImpl customerDao = new CustomerDaoImpl();
	
	public static Customer toCustomer(CustomerDTO customerdto) {
		Customer customer = new Customer();
		customer.setId(customerdto.getId());
		customer.setfirstName(customerdto.getFirstName());
		customer.setlastName(customerdto.getLastName());
		customer.setEmail(customerdto.getEmail());
		customer.setPhoneNumber(customerdto.getPhoneNumber());
		customer.setAddress(customerdto.getAddress());
		customer.setdateOfBirth(customerdto.getDateOfBirth());
		return customer;
	}
}
