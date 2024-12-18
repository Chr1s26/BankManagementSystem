package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.AccountTransactionDaoImpl;
import Model.AccountTransaction;
import View.AccountTransactionListingPage;

public class AccountTransactionListingController extends BaseController {
	
	private AccountTransactionListingPage view;
	private AccountTransactionDaoImpl accountTransactionDao;

	public AccountTransactionListingController() {
		super(new AccountTransactionListingPage());
		this.accountTransactionDao = new AccountTransactionDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (AccountTransactionListingPage) this.getView();
		
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getAccountTransactionData(),columns);
		
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleDeleteButton() {
		 int selectedRowIndex = getSelectedRow();

		 if (selectedRowIndex == -1) {
			 JOptionPane.showMessageDialog(this.view, "Please select a AccountTransaction to delete.");
			 return;
		 }

		 int AccountTransactionId = getAccountTransactionIdFromSelectedRow(selectedRowIndex);

		 if (confirmDeletion(AccountTransactionId)) {
			 deleteAccountTransactionAndRefresh(AccountTransactionId);
		 }
	}

	private void handleUpdateButton() {
		
	}

	private void handleCreateButton() {
		
	}
	
	public String[][] getAccountTransactionData(){
		List<AccountTransaction> AccountTransactions = accountTransactionDao.getAll();
		String[][] AccountTransactionArray = new String[AccountTransactions.size()][this.view.getColumns().length];
		int rowCount = 0;
		for(AccountTransaction AccountTransaction : AccountTransactions) {
			AccountTransactionArray[rowCount][0] = AccountTransaction.getId()+""; 
			AccountTransactionArray[rowCount][1] = AccountTransaction.getTransactionType()+"";
			AccountTransactionArray[rowCount][2] = AccountTransaction.getAmount()+"";
			AccountTransactionArray[rowCount][3] = AccountTransaction.getTransactionDate()+"";
			AccountTransactionArray[rowCount][4] = AccountTransaction.getDescription();
			AccountTransactionArray[rowCount][5] = AccountTransaction.getStatus()+"";
			AccountTransactionArray[rowCount][6] = AccountTransaction.getCurrency()+"";
			AccountTransactionArray[rowCount][7] = AccountTransaction.getTransaction()+"";
			AccountTransactionArray[rowCount][8] = AccountTransaction.getAccount()+"";
			rowCount++;
		}
		return AccountTransactionArray;
	}
	

	private int getSelectedRow() {
			return this.view.getDataTableTemplate().getSelectedRow();
		}
	

	private int getAccountTransactionIdFromSelectedRow(int rowIndex) {
			return Integer.parseInt(getAccountTransactionData()[rowIndex][0]);
		}
	

	private boolean confirmDeletion(int AccountTransactionId) {
			int response = JOptionPane.showConfirmDialog(
					this.view,
					"Are you sure you want to delete AccountTransaction with ID " + AccountTransactionId + "?",
					"Confirm Deletion",
					JOptionPane.YES_NO_OPTION
		 );
			return response == JOptionPane.YES_OPTION;
		}
		
	private void deleteAccountTransactionAndRefresh(int AccountTransactionId) {
			 accountTransactionDao.delete(AccountTransactionId);
			 this.refreshTableData();
			}
	
	public void refreshTableData() {
		this.view.refreshDataTable(getAccountTransactionData());
	}
}
