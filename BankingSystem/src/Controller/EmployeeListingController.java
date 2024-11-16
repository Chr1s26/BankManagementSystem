package Controller;

import java.util.List;

import javax.swing.JFrame;

import Dao.EmployeeDaoImpl;
import Model.Employee;
import View.EmployeeListingPage;

public class EmployeeListingController extends BaseController {
	
	private EmployeeListingPage view;
	private EmployeeDaoImpl employeeDao;

	public EmployeeListingController() {
		super(new EmployeeListingPage());
		this.authenticate();
		this.employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public void initController() {
		this.view = (EmployeeListingPage) this.getView();
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
		this.getAllEmployeeData();
	}

	private Object handleDeleteButton() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object handleUpdateButton() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object handleCreateButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void getAllEmployeeData() {
		List<Employee> employees = employeeDao.getAll();
		this.view.setEmployeeData(getEmployeeStrings(employees));
	}
	
	public String[][] getEmployeeStrings(List<Employee> employees){
		String[][] employeeArray = new String[employees.size()][this.view.getColumns().length];
		int rowCount = 0;
		for(Employee employee : employees) {
			employeeArray[rowCount][0] = employee.getId()+""; 
			employeeArray[rowCount][1] = employee.getfirstName();
			employeeArray[rowCount][2] = employee.getlastName();
			employeeArray[rowCount][3] = employee.getEmail();
			employeeArray[rowCount][4] = employee.getPhoneNumber();
			employeeArray[rowCount][5] = employee.getPosition();
			employeeArray[rowCount][6] = employee.getSalary()+"";
			employeeArray[rowCount][7] = employee.getBranch().toString();
			employeeArray[rowCount][8] = employee.getEncryptPassword();
			rowCount++;
		}
		return employeeArray;
	}

}
