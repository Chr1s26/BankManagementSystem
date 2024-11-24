package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.CardDaoImpl;
import Model.Card;
import View.CardListingPage;

public class CardListingController extends BaseController {
	
	private CardListingPage view;
	private CardDaoImpl cardDao;

	public CardListingController() {
		super(new CardListingPage());
		this.cardDao = new CardDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (CardListingPage) this.getView();
		
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getCardData(),columns);
		
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleDeleteButton() {
		 int selectedRowIndex = getSelectedRow();

		 if (selectedRowIndex == -1) {
			 JOptionPane.showMessageDialog(this.view, "Please select a Card to delete.");
			 return;
		 }

		 int CardId = getCardIdFromSelectedRow(selectedRowIndex);

		 if (confirmDeletion(CardId)) {
			 deleteCardAndRefresh(CardId);
		 }
	}

	private void handleUpdateButton() {
		new CardUpdateController(this,getCardIdFromSelectedRow(getSelectedRow()));
	}

	private void handleCreateButton() {
		new CardCreateController(this);

	}
	
	public String[][] getCardData(){
		List<Card> Cards = cardDao.getAll();
		String[][] CardArray = new String[Cards.size()][this.view.getColumns().length];
		int rowCount = 0;
		for(Card Card : Cards) {
			CardArray[rowCount][0] = Card.getId()+""; 
			CardArray[rowCount][1] = Card.getCardNumber();
			CardArray[rowCount][2] = Card.getCardType();
			CardArray[rowCount][3] = Card.getExpireDate()+"";
			CardArray[rowCount][4] = Card.getSecurityCode()+"";
			CardArray[rowCount][5] = Card.getCustomer().getfirstName();
			CardArray[rowCount][6] = Card.getAccount().getaccountNumber();
			rowCount++;
		}
		return CardArray;
	}
	

	private int getSelectedRow() {
			return this.view.getDataTableTemplate().getSelectedRow();
		}
	

	private int getCardIdFromSelectedRow(int rowIndex) {
			return Integer.parseInt(getCardData()[rowIndex][0]);
		}
	

	private boolean confirmDeletion(int CardId) {
			int response = JOptionPane.showConfirmDialog(
					this.view,
					"Are you sure you want to delete Card with ID " + CardId + "?",
					"Confirm Deletion",
					JOptionPane.YES_NO_OPTION
		 );
			return response == JOptionPane.YES_OPTION;
		}
		
	private void deleteCardAndRefresh(int CardId) {
			 cardDao.delete(CardId);
			 this.refreshTableData();
			}
	
	public void refreshTableData() {
		this.view.refreshDataTable(getCardData());
	}
}
