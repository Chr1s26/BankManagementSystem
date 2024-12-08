package Service;

import Dao.EmployeeDaoImpl;
import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.InvalidTokenException;
import Exception.NotConfirmedException;
import Model.Employee;
import Model.Transaction;

public class AuthenticationService {
	
	public static Employee employee;

	public static final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
			
	public static void login(String email,String password) throws IncorrectPasswordException, IncorrectEmailException, NotConfirmedException{
		employee = employeeDao.validateEmployee(email,password);
		if(!employee.isConfirmed()) {
			throw new NotConfirmedException("Account is not confirmed!!");
		}
	}
	 
	public static Employee authenticate() throws InvalidTokenException {
		if(employee != null) {
			employeeDao.validateLoginToken(employee);
			return employee;
			}
		else {
			throw new InvalidTokenException("Need to login!!");
		}
		}
	
	public static Employee getEmployee() {
		return employee;
	}
	
	public static void otpAuthenticate(Transaction transaction) throws NotConfirmedException {
		if(!transaction.isConfirmed()) {
			throw new NotConfirmedException("Transaction is not confirmed!!");
		}
	}
}
