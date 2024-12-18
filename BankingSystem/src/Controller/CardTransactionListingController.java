package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.CardTransactionDaoImpl;
import Model.CardTransaction;
import View.CardTransactionListingPage;

public class CardTransactionListingController extends BaseController {
	
	private CardTransactionListingPage view;
	private CardTransactionDaoImpl CardTransactionDao;

	public CardTransactionListingController() {
		super(new CardTransactionListingPage());
		this.CardTransactionDao = new CardTransactionDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (CardTransactionListingPage) this.getView();
		
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getCardTransactionData(),columns);
		
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleDeleteButton() {
		 int selectedRowIndex = getSelectedRow();

		 if (selectedRowIndex == -1) {
			 JOptionPane.showMessageDialog(this.view, "Please select a CardTransaction to delete.");
			 return;
		 }

		 int CardTransactionId = getCardTransactionIdFromSelectedRow(selectedRowIndex);

		 if (confirmDeletion(CardTransactionId)) {
			 deleteCardTransactionAndRefresh(CardTransactionId);
		 }
	}

	private void handleUpdateButton() {
		
	}

	private void handleCreateButton() {
		
	}
	
	public String[][] getCardTransactionData(){
		List<CardTransaction> CardTransactions = CardTransactionDao.getAll();
		String[][] CardTransactionArray = new String[CardTransactions.size()][this.view.getColumns().length];
		int rowCount = 0;
		for(CardTransaction CardTransaction : CardTransactions) {
			CardTransactionArray[rowCount][0] = CardTransaction.getId()+""; 
			CardTransactionArray[rowCount][1] = CardTransaction.getAmount()+"";
			CardTransactionArray[rowCount][2] = CardTransaction.getTransactionDate()+"";
			CardTransactionArray[rowCount][3] = CardTransaction.getDescription()+"";
			CardTransactionArray[rowCount][4] = CardTransaction.getAccount().getaccountNumber();
			CardTransactionArray[rowCount][5] = CardTransaction.getCard().getCardNumber();
			rowCount++;
		}
		return CardTransactionArray;
	}
	

	private int getSelectedRow() {
			return this.view.getDataTableTemplate().getSelectedRow();
		}
	

	private int getCardTransactionIdFromSelectedRow(int rowIndex) {
			return Integer.parseInt(getCardTransactionData()[rowIndex][0]);
		}
	

	private boolean confirmDeletion(int CardTransactionId) {
			int response = JOptionPane.showConfirmDialog(
					this.view,
					"Are you sure you want to delete CardTransaction with ID " + CardTransactionId + "?",
					"Confirm Deletion",
					JOptionPane.YES_NO_OPTION
		 );
			return response == JOptionPane.YES_OPTION;
		}
		
	private void deleteCardTransactionAndRefresh(int CardTransactionId) {
			 CardTransactionDao.delete(CardTransactionId);
			 this.refreshTableData();
			}
	
	public void refreshTableData() {
		this.view.refreshDataTable(getCardTransactionData());
	}
}
