package Controller;

import java.util.ArrayList;
import java.util.List;

import DTO.TransactionDTO;
import Dao.AccountDaoImpl;
import Model.Account;
import View.AccountListingPage;
import View.TransactionListingPage;

public class TransactionListingController extends BaseController {
	
	public TransactionListingPage view;
	private AccountDaoImpl accountDao;
	private Account account;
	private int type;
	
	public TransactionListingController(Account account,int type) {
		super(new TransactionListingPage());
		this.type = type;
		this.account = account;
		this.accountDao = new AccountDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (TransactionListingPage) this.getView();
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getAccountData(), columns);
	}
	
	public String[][] getAccountData() {
		List<TransactionDTO> Accounts = new ArrayList<TransactionDTO>();
		
		if(type == 0) {
			Accounts = accountDao.getAllTransaction(account);
		}else if(type == 1) {
			Accounts = accountDao.getAllDepositTransaction(account);
		}else if(type == 2) {
			Accounts = accountDao.getAllWithDrawlTransaction(account);
		}
		
		String[][] AccountArray = new String[Accounts.size()][this.view.getColumns().length];
		int rowCount = 0;
		for (TransactionDTO Account : Accounts) {
			AccountArray[rowCount][0] = Account.getTransactionId() + "";
			AccountArray[rowCount][1] = Account.getAccountType()+"";
			AccountArray[rowCount][2] = Account.getCreatedAt()+"";
			AccountArray[rowCount][3] = Account.getAccountNumber() + "";
			AccountArray[rowCount][4] = Account.getAmount() + "";
			AccountArray[rowCount][5] = Account.getDescription();
			rowCount++;
		}
		return AccountArray;
	}
}
