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
		
		this.baseWindow.add(panel,BorderLayout.SOUTH);
		
		this.addActionOnCreateButton();
		this.addActionOnUpdateButton();
		prepareBaseWindow();
	}
	
	public void addActionOnCreateButton() {
		this.createButton.addActionListener(e -> employeeCreateAction());
	}
	
	public void employeeCreateAction() {
		EmployeeRegisterForm employeeRegisterForm = new EmployeeRegisterForm();
	}
	
	public void addActionOnUpdateButton() {
		this.updateButton.addActionListener(e -> employeeUpdateAction());
	}
	
	public void employeeUpdateAction() {
		EmployeeUpdateForm employeeUpdateForm = new EmployeeUpdateForm();
	}
	
	public void prepareBaseWindow() {
		this.baseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Information");
		this.baseWindow.setSize(1000,400);
		this.baseWindow.setVisible(true);
	}
}
