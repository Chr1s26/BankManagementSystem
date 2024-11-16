package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dao.EmployeeDaoImpl;

public class EmployeeListingPage extends BaseWindow {
	
	private EmployeeDaoImpl employeeDao;
	private String[] columns = {"id","firstname","lastname","email","phone number","employee-position","salary","branch","encrypt password"};
	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JPanel panel;
	private BaseWindow parentWindow;
	private String[][] employeeData = new String[1][9];
	
	public EmployeeListingPage() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		employeeDao = new EmployeeDaoImpl();
		
		this.createDataTable(employeeData,this.columns);
		
		this.createButton = new JButton("Create");
		this.updateButton = new JButton("Update");
		this.deleteButton = new JButton("Delete");
		
		panel.add(createButton);
		panel.add(updateButton);
		panel.add(deleteButton);
		
		this.add(panel,BorderLayout.SOUTH);
		
		prepareBaseWindow();
	}
	
	
	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Information");
		this.setSize(1000,400);
//		this.setVisible(true);
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public String[][] getEmployeeData() {
		return employeeData;
	}

	public void setEmployeeData(String[][] employeeData) {
		this.employeeData = employeeData;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

}
