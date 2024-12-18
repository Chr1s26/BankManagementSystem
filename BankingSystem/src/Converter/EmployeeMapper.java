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
		employee.setId(employeeDto.getId());
		return employee;
	}
	
	public static EmployeeDTO toEmployeeDTO(Employee employee) {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirstName(employee.getfirstName());
		employeeDTO.setLastName(employee.getlastName());
		employeeDTO.setBranch(employee.getBranch().getId());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setSalary(employee.getSalary()+"");
		employeeDTO.setPhoneNumber(employee.getPhoneNumber());
		employeeDTO.setPosition(employee.getPosition());
		return employeeDTO;
	}

}
