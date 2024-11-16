package Dao;

import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.InvalidTokenException;
import Model.Employee;

public abstract class EmployeeDao extends AbstractDao<Employee>{
	
	public abstract Employee findByName(String name);
	public abstract boolean isEmailExists(String email);
	public abstract boolean isPhoneExists(String phoneNumber);
	public abstract Employee getEmployeeByEmployeeEmail(String email);
	public abstract Employee validateEmployee(String email,String password) throws IncorrectPasswordException, IncorrectEmailException;
	public abstract void updateLoginToken(Employee employee);
	public abstract void validateLoginToken(Employee employee) throws InvalidTokenException;
	public abstract void setConfimedAt(Employee employee);
}
