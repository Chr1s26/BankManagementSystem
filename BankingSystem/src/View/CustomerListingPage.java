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
	
	public CustomerListingPage() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,3));
		customerDao = new CustomerDaoImpl();
		
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
		this.setTitle("Customer Information");
		this.setSize(1300,400);
	}

	public CustomerDaoImpl getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
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
}
