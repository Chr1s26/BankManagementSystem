package Test;

import java.io.IOException;

import Service.AccountService;
import Service.BranchService;
import Service.EmployeeService;

public class MainTest {
	
	public static void main(String[] args) throws IOException {
//		BranchService branchService = new BranchService();
//		branchService.delete();
//		EmployeeService employeeService = new EmployeeService();
//		employeeService.updateEmployee();
		AccountService accountService = new AccountService();
		accountService.createAccount();
	}
}
