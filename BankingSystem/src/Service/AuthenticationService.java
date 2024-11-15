package Service;

import Dao.EmployeeDaoImpl;
import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.InvalidTokenException;
import Model.Employee;

public class AuthenticationService {
	
	public static Employee employee;

	public static final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	
	public static void login(String email,String password) throws IncorrectPasswordException, IncorrectEmailException {
		employee = employeeDao.validateEmployee(email,password);
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
}
