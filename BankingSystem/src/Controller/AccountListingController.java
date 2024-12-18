package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import Dao.AccountDaoImpl;
import Dao.AccountDaoImpl;
import Model.Account;
import View.AccountListingPage;
import View.AccountListingPage;

public class AccountListingController extends BaseController {

	private AccountListingPage view;
	private AccountDaoImpl accountDao;

	public AccountListingController() {
		super(new AccountListingPage());
		this.accountDao = new AccountDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (AccountListingPage) this.getView();

		String[] columns = this.view.getColumns();
		this.view.createDataTable(getAccountData(), columns);

		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());

	}

	private void handleDeleteButton() {

		int selectedRowIndex = getSelectedRow();

		if (selectedRowIndex == -1) {
			JOptionPane.showMessageDialog(this.view, "Please select a account to delete.");
			return;
		}

		int accountId = getaccountIdFromSelectedRow(selectedRowIndex);

		if (confirmDeletion(accountId)) {
			deleteaccountAndRefresh(accountId);
		}
	}

	private void handleUpdateButton() {
		new AccountUpdateController(this,this.getaccountIdFromSelectedRow(getSelectedRow()));
	}

	private void handleCreateButton() {
		new AccountCreateController(this);
	}

	public String[][] getAccountData() {
		List<Account> Accounts = accountDao.getAll();
		String[][] AccountArray = new String[Accounts.size()][this.view.getColumns().length];
		int rowCount = 0;
		for (Account Account : Accounts) {
			AccountArray[rowCount][0] = Account.getId() + "";
			AccountArray[rowCount][1] = Account.getaccountNumber();
			AccountArray[rowCount][2] = Account.getaccountType()+"";
			AccountArray[rowCount][3] = Account.getBalance() + "";
			AccountArray[rowCount][4] = Account.getcreatedAt() + "";
			AccountArray[rowCount][5] = Account.getBranch().toString();
			AccountArray[rowCount][6] = Account.getCustomer().getfirstName();
			rowCount++;
		}
		return AccountArray;
	}

	private int getSelectedRow() {
		return this.view.getDataTableTemplate().getSelectedRow();
	}

	private int getaccountIdFromSelectedRow(int rowIndex) {
		return Integer.parseInt(getAccountData()[rowIndex][0]);
	}

	private boolean confirmDeletion(int accountId) {
		int response = JOptionPane.showConfirmDialog(this.view,
				"Are you sure you want to delete account with ID " + accountId + "?", "Confirm Deletion",
				JOptionPane.YES_NO_OPTION);
		return response == JOptionPane.YES_OPTION;
	}

	private void deleteaccountAndRefresh(int accountId) {
		accountDao.delete(accountId);
		this.refreshTableData();
	}

	public void refreshTableData() {
		this.view.refreshDataTable(getAccountData());
	}

}
