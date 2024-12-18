package Controller;

import java.util.ArrayList;
import java.util.List;

import DTO.TransactionDTO;
import Dao.AccountDaoImpl;
import Model.Account;

public class AccountTransactionController extends TransactionListingController {
	
	private static String[] columns = {"Transaction Id","Transaction Type","CreatedAt","To Account Number","Note"};
	private AccountDaoImpl accountDao;
	private Account account;
	
	public AccountTransactionController(Account account,int type) {
		super(account,type,columns);
		this.account = account;
		
	}

	@Override
	public List<TransactionDTO> getTransaction(int type) {
		this.accountDao = new AccountDaoImpl();
		List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();
		if(type == 0) {
			transactions = accountDao.getAllTransaction(account);
		}else if(type == 1) {
			transactions = accountDao.getAllDepositTransaction(account);
		}else if(type == 2) {
			transactions = accountDao.getAllWithDrawlTransaction(account);
		}
		
		return transactions;
		
	}

}
