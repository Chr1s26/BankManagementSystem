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
	
	public static void authenticate() throws InvalidTokenException {
		if(employee != null) {
			try {
				employeeDao.validateLoginToken(employee);
			} catch (InvalidTokenException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Employee getEmployee() {
		return employee;
	}
}
