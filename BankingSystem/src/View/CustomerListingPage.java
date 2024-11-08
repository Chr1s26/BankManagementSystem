package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Dao.CustomerDaoImpl;

public class CustomerListingPage extends BaseWindow {
	
	private CustomerDaoImpl customerDao;
	private String[] columns = {"id","firstname","lastname","email","phone number","address","date of birth","created at","updated at","created by","updated by"};
	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JPanel panel;
	private String[][] customerData = new String[1][11];
	
	public CustomerListingPage() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		customerDao = new CustomerDaoImpl();
		
		this.createDataTable(customerData,this.columns);
		
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
		this.createButton.addActionListener(e -> customerCreateAction());
	}
	
	public void customerCreateAction() {
//		customerRegisterForm customerRegisterForm = new customerRegisterForm();
	}
	
	public void addActionOnUpdateButton() {
		this.updateButton.addActionListener(e -> customerUpdateAction());
	}
	
	public void customerUpdateAction() {
//		customerUpdateForm customerUpdateForm = new customerUpdateForm();
	}
	
	public void prepareBaseWindow() {
		this.baseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Customer Information");
		this.baseWindow.setSize(1300,400);
		this.baseWindow.setVisible(true);
	}
}
