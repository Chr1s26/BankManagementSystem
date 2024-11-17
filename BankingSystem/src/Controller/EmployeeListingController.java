package Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Dao.EmployeeDaoImpl;
import Model.Employee;
import View.EmployeeListingPage;

public class EmployeeListingController extends BaseController {
	
	private EmployeeListingPage view;
	private EmployeeDaoImpl employeeDao;

	public EmployeeListingController() {
		super(new EmployeeListingPage());
		this.employeeDao = new EmployeeDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (EmployeeListingPage) this.getView();
		
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getEmployeeData(),columns);
		
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleDeleteButton() {
		 int selectedRowIndex = getSelectedRow();

		 if (selectedRowIndex == -1) {
			 JOptionPane.showMessageDialog(this.view, "Please select a employee to delete.");
			 return;
		 }

		 int employeeId = getemployeeIdFromSelectedRow(selectedRowIndex);

		 if (confirmDeletion(employeeId)) {
			 deleteEmployeeAndRefresh(employeeId);
		 }
	}

	private void handleUpdateButton() {
		new EmployeeUpdateController(this,this.getemployeeIdFromSelectedRow(getSelectedRow()));
	}

	private void handleCreateButton() {
		new EmployeeRegisterController(this);
	}
	
	public String[][] getEmployeeData(){
		List<Employee> employees = employeeDao.getAll();
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
	

	private int getSelectedRow() {
			return this.view.getDataTableTemplate().getSelectedRow();
		}
	

	private int getemployeeIdFromSelectedRow(int rowIndex) {
			return Integer.parseInt(getEmployeeData()[rowIndex][0]);
		}
	

	private boolean confirmDeletion(int employeeId) {
			int response = JOptionPane.showConfirmDialog(
					this.view,
					"Are you sure you want to delete employee with ID " + employeeId + "?",
					"Confirm Deletion",
					JOptionPane.YES_NO_OPTION
		 );
			return response == JOptionPane.YES_OPTION;
		}
		
	private void deleteEmployeeAndRefresh(int employeeId) {
			 employeeDao.delete(employeeId);
			 this.refreshTableData();
			}
	
	public void refreshTableData() {
		this.view.refreshDataTable(getEmployeeData());
	}

}


