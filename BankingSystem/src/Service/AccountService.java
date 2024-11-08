package Service;

import java.io.IOException;
import java.sql.Date;

import Dao.AccountDaoImpl;
import Dao.BranchDaoImpl;
import Dao.CustomerDaoImpl;
import Dao.EmployeeDaoImpl;
import Model.Account;
import Model.Branch;
import Model.Customer;
import Model.Employee;
import Util.DateConverter;

public class AccountService extends BaseService {
	
	private AccountDaoImpl accountDao;
	private BranchDaoImpl branchDao;
	private EmployeeDaoImpl employeeDao;
	private CustomerDaoImpl customerDao;
	
	public AccountService() {
		accountDao = new AccountDaoImpl();
		branchDao = new BranchDaoImpl();
		employeeDao = new EmployeeDaoImpl();
		customerDao = new CustomerDaoImpl();
	}
	
	public void createAccount() {
		try {
			Customer customer = getCustomerInfo();
			System.out.println("Enter the Account Number : ");
			String number = bufferedReader.readLine();
			System.out.println("Enter the Account Type : ");
			String type = bufferedReader.readLine();
			System.out.println("Enter the balance : ");
			double balance = Double.parseDouble(bufferedReader.readLine());
			System.out.print("Enter the branch Name : ");
			int branchId = getBranchInfo(bufferedReader.readLine());
			
			Account account = new Account(number,type,balance,branchDao.getById(branchId),customer);
			
			System.out.print("Account Created Successfully !");
			}
			catch(IOException e){
				System.out.println("Error reading Input : "+e.getMessage());
			}
			catch(Exception e) {
				System.out.print("Unexpected Error occur : "+e.getMessage());
			}
		}
	
	public int getBranchInfo(String name) {
		Branch branch = branchDao.findByName(name);
		int branchId = branch.getId();
		return branchId;
	}
	
	public Customer getCustomerInfo() throws IOException {
		System.out.print("Please enter the Customer firstname : ");
		String fname = bufferedReader.readLine();
		System.out.print("Please enter the Customer lastname : ");
		String lname = bufferedReader.readLine();
		System.out.print("Please enter the Customer email : ");
		String email = bufferedReader.readLine();
		System.out.print("Please enter the Customer phone number : ");
		String phone = bufferedReader.readLine();
		System.out.print("Please enter the Customer address : ");
		String address = bufferedReader.readLine();
		System.out.print("Please enter the Customer date of birth(yyyy-MM-dd HH:mm:ss): ");
		Date date = DateConverter.toSqlDate(DateConverter.toDateTimeObj(bufferedReader.readLine())); 
		Customer customer = new Customer(fname,lname,email,phone,address,date);
		customerDao.create(customer);
		System.out.println("Customer Created Successfully !");
		return customerDao.findByName(fname);
	}
	
	}

