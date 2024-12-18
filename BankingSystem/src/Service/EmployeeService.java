package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Dao.BranchDaoImpl;
import Dao.EmployeeDaoImpl;
import Model.Branch;
import Model.Employee;

public class EmployeeService extends BaseService {
	
	private EmployeeDaoImpl employeeDao;
	private BranchDaoImpl branchDao;
	
	public EmployeeService() {
		employeeDao = new EmployeeDaoImpl();
		branchDao = new BranchDaoImpl();
	}
	
	public void createEmployee() throws IOException {
		try {
		System.out.print("Please enter the employee FirstName : ");
		String fname = bufferedReader.readLine();
		System.out.print("Please enter the employee LastName : ");
		String lname = bufferedReader.readLine();
		System.out.print("Please enter the employee email : ");
		String email = bufferedReader.readLine();
		System.out.print("Please enter the employee phone number : ");
		String phone = bufferedReader.readLine();
		System.out.print("Please enter the employee position : ");
		String position = bufferedReader.readLine();
		System.out.print("Please enter the employee salary : ");
		double salary = Double.parseDouble(bufferedReader.readLine());
		List<Branch> Allbranch = branchDao.getAll();
		for(Branch branches : Allbranch) {
			System.out.println(branches);
		}
		System.out.print("Please choose the branch id : ");
		int branchId = Integer.parseInt(bufferedReader.readLine());
		Branch branch = branchDao.getById(branchId);
		
		System.out.print("Please choose the password |: ");
		String password = bufferedReader.readLine();
		
		Employee employee = new Employee(fname,lname,email,phone,position,salary,branch,password);
		employeeDao.create(employee);
		System.out.print("Employee Created Successfully!!");
		}
		catch(IOException e) {
			System.out.print("Error Reading Input : "+e.getMessage());
		}catch(Exception e) {
			System.out.print("Unexcepted Error Occur : "+e.getMessage());
		}
	}
	
	public void updateEmployee() {
		try {
			System.out.println("Please Enter the Employee First Name you want to update: ");
			String name = bufferedReader.readLine();
			Employee employee = employeeDao.findByName(name);
			System.out.println(employee);
			
			System.out.print("Please enter the employee FirstName : ");
			employee.setfirstName(bufferedReader.readLine());
			System.out.print("Please enter the employee LastName : ");
			employee.setlastName(bufferedReader.readLine());
			System.out.print("Please enter the employee email : ");
			employee.setEmail(bufferedReader.readLine());
			System.out.print("Please enter the employee phone number : ");
			employee.setPhoneNumber(bufferedReader.readLine());
			System.out.print("Please enter the employee position : ");
			employee.setPhoneNumber(bufferedReader.readLine());
			System.out.print("Please enter the employee salary : ");
			employee.setSalary(Double.parseDouble(bufferedReader.readLine()));
			System.out.print("Please enter the password : ");
			employee.setEncryptPassword(bufferedReader.readLine());
			
			List<Branch> Allbranch = branchDao.getAll();
			for(Branch branches : Allbranch) {
				System.out.println(branches);
			}
			System.out.print("Please choose the branch id : ");
			int branchId = Integer.parseInt(bufferedReader.readLine());
			employee.setBranch(branchDao.getById(branchId));
			employeeDao.update(employee);
			System.out.print("Employee updated successfully!!");
		}catch(IOException e) {
			System.out.print("Error Reading Input : "+e.getMessage());
		}catch(Exception e) {
			System.out.print("Unexcepted Error Occur : "+e.getMessage());
		}
	}
	
	public void deleteEmployee() throws IOException {
		System.out.println("Please Enter the Employee First Name you want to delete: ");
		String name = bufferedReader.readLine();
		Employee employee = employeeDao.findByName(name);
		employeeDao.delete(employee.getId());
		System.out.print("Employee Deleted Successfully !!!");
	}
	

}
