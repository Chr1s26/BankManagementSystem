package Controller;

import java.util.ArrayList;
import java.util.List;

import DTO.TransactionDTO;
import Dao.AccountDaoImpl;
import Model.Account;
import View.AccountListingPage;
import View.TransactionListingPage;

public abstract class TransactionListingController extends BaseController {
	
	public TransactionListingPage view;
	private int type;
	private String[] columns;
	
	public TransactionListingController(Account account,int type,String[] columns) {
		super(new TransactionListingPage(columns));
		this.columns = columns;
		this.type = type;
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (TransactionListingPage) this.getView();
		this.view.createDataTable(fetchTransactionData(), columns);
	}
	
	public abstract List<TransactionDTO> getTransaction(int type);
	
	public String[][] fetchTransactionData() {
		List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
		
		transactions = getTransaction(type);
		
		String[][] transactionArray = new String[transactions.size()][this.view.getColumns().length];
		int rowCount = 0;
		for (TransactionDTO transaction : transactions) {
			transactionArray[rowCount][0] = transaction.getTransactionId() + "";
			transactionArray[rowCount][1] = transaction.getType()+"";
			transactionArray[rowCount][2] = transaction.getCreatedAt()+"";
			transactionArray[rowCount][3] = transaction.getNumber() + "";
			transactionArray[rowCount][4] = transaction.getAmount() + "";
			transactionArray[rowCount][5] = transaction.getDescription();
			rowCount++;
		}
		return transactionArray;
	}
}
