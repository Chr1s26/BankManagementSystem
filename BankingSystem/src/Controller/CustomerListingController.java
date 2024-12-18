package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.CustomerDaoImpl;
import Model.Customer;
import View.CustomerListingPage;

public class CustomerListingController extends BaseController {

	private CustomerListingPage view;
	private CustomerDaoImpl customerDao;

	public CustomerListingController() {
		super(new CustomerListingPage());
		this.customerDao = new CustomerDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (CustomerListingPage) this.getView();

		String[] columns = this.view.getColumns();
		this.view.createDataTable(getCustomerData(), columns);

		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleUpdateButton() {
		new CustomerUpdateController(this,this.getcustomerIdFromSelectedRow(getSelectedRow()));
	}

	private void handleCreateButton() {
		new CustomerCreateController(this);
	}

	private void handleDeleteButton() {
		int selectedRowIndex = getSelectedRow();

		if (selectedRowIndex == -1) {
			JOptionPane.showMessageDialog(this.view, "Please select a customer to delete.");
			return;
		}

		int customerId = getcustomerIdFromSelectedRow(selectedRowIndex);

		if (confirmDeletion(customerId)) {
			deletecustomerAndRefresh(customerId);
		}
	}

	public String[][] getCustomerData() {
		List<Customer> Customers = customerDao.getAll();
		String[][] CustomerArray = new String[Customers.size()][this.view.getColumns().length];
		int rowCount = 0;
		for (Customer Customer : Customers) {
			CustomerArray[rowCount][0] = Customer.getId() + "";
			CustomerArray[rowCount][1] = Customer.getfirstName();
			CustomerArray[rowCount][2] = Customer.getlastName();
			CustomerArray[rowCount][3] = Customer.getEmail();
			CustomerArray[rowCount][4] = Customer.getPhoneNumber();
			CustomerArray[rowCount][5] = Customer.getAddress();
			CustomerArray[rowCount][6] = Customer.getdateOfBirth() + "";
			CustomerArray[rowCount][7] = Customer.getCreatedAt() + "";
			CustomerArray[rowCount][8] = Customer.getUpdatedAt() + "";
			CustomerArray[rowCount][7] = Customer.getcreatedBy() + "";
			CustomerArray[rowCount][8] = Customer.getupdatedBy() + "";
			rowCount++;
		}
		return CustomerArray;
	}

	private int getSelectedRow() {
		return this.view.getDataTableTemplate().getSelectedRow();
	}

	private int getcustomerIdFromSelectedRow(int rowIndex) {
		return Integer.parseInt(getCustomerData()[rowIndex][0]);
	}

	private boolean confirmDeletion(int customerId) {
		int response = JOptionPane.showConfirmDialog(this.view,
				"Are you sure you want to delete customer with ID " + customerId + "?", "Confirm Deletion",
				JOptionPane.YES_NO_OPTION);
		return response == JOptionPane.YES_OPTION;
	}

	private void deletecustomerAndRefresh(int customerId) {
		customerDao.delete(customerId);
		this.refreshTableData();
	}

	public void refreshTableData() {
		this.view.refreshDataTable(getCustomerData());
	}

}
