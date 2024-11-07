package Dao;

import Model.Customer;

public abstract class CustomerDao extends AbstractDao<Customer>{
	public abstract Customer findByName(String fname);
}
