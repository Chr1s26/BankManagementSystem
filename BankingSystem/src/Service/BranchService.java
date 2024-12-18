package Service;

import java.io.IOException;

import Dao.BranchDaoImpl;
import Model.Branch;

public class BranchService extends BaseService {
	
	private BranchDaoImpl branchDao;
	
	public BranchService() {
		branchDao = new BranchDaoImpl();
	}
	
	public void createBranch() throws IOException {
		this.branchInfo();
	}
	
	public void updateBranch() throws IOException {
		try {
			System.out.println("Please Enter the Bank Name you want to update: ");
			String name = bufferedReader.readLine();
			Branch branch = branchDao.findByName(name);
			
			System.out.println(branch);
			
			System.out.println("Branch Name : ");
			branch.setName(bufferedReader.readLine());
			
			System.out.println("Branch Address : ");
			branch.setAddress(bufferedReader.readLine());
			
			System.out.println("Branch PhoneNumber : ");
			branch.setPhoneNumber(bufferedReader.readLine());
			branchDao.update(branch);
			System.out.print("Branch Update Successfully!!");
		}catch(IOException e) {
			System.out.print("Error Reading Input : "+e.getMessage());
		}catch(Exception e) {
			System.out.print("Unexcepted Error Occur : "+e.getMessage());
		}
	}
	
	public void delete() {
		try {
			System.out.println("Please Enter the Bank Name you want to delete: ");
			String name = bufferedReader.readLine();
			Branch branch = branchDao.findByName(name);
			
			branchDao.delete(branch.getId());
			System.out.print("Branch Deleted Successfully!!");
			
		}catch(IOException e) {
			System.out.print("Error Reading Input : "+e.getMessage());
		}catch(Exception e) {
			System.out.print("Unexcepted Error Occur : "+e.getMessage());
		}
	}
	
	public void branchInfo() throws IOException {
		try {
		System.out.println("Enter the branch name : ");
		String name = bufferedReader.readLine();
		System.out.println("Enter the address : ");
		String address = bufferedReader.readLine();
		System.out.println("Enter the phone number : ");
		String phone = bufferedReader.readLine();
		Branch branch = new Branch(name,address,phone);
		branchDao.create(branch);
		System.out.print("Branch Created Successfully !");
		}
		catch(IOException e){
			System.out.println("Error reading Input : "+e.getMessage());
		}
		catch(Exception e) {
			System.out.print("Unexpected Error occur : "+e.getMessage());
		}
	}
}
