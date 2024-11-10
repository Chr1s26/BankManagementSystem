package Converter;

import DTO.EmployeeDTO;
import Dao.BranchDaoImpl;
import Model.Employee;
import Util.PasswordUtil;

public class EmployeeMapper {
	
	public static BranchDaoImpl branchDao = new BranchDaoImpl();
	
	
	public static Employee toEmployee(EmployeeDTO employeeDto) {
		
		Employee employee = new Employee();
		employee.setfirstName(employeeDto.getFirstName());
		employee.setlastName(employeeDto.getLastName());
		employee.setBranch(branchDao.getById(employeeDto.getBranchId()));
		employee.setEmail(employeeDto.getEmail());
		employee.setSalary(Double.parseDouble(employeeDto.getSalary()));
		employee.setEncryptPassword(PasswordUtil.encryptPassword(employeeDto.getPassword()));
		employee.setPhoneNumber(employeeDto.getPhoneNumber());
		employee.setPosition(employeeDto.getPosition());
		return employee;
	}

}
