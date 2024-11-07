package Dao;

import Model.Employee;

public abstract class EmployeeDao extends AbstractDao<Employee>{
	
	public abstract Employee findByName(String name);
}
