package Service;

import Converter.AccountTransactionMapper;
import DTO.TransferMoneyDTO;
import Dao.AccountTransactionDaoImpl;

import Model.Account;
import Model.AccountTransaction;

public class TransferMoneyService {
	
	private TransferMoneyDTO transferMoneyDto;
	private AccountTransactionDaoImpl transactionDao;

	
	public TransferMoneyService(TransferMoneyDTO transferMoneyDto) {
		this.transferMoneyDto = transferMoneyDto;
		this.transactionDao = new AccountTransactionDaoImpl();
		this.transferProcess();
	}
	
	public void transferProcess() {
		AccountTransaction[] accountTransaction = AccountTransactionMapper.toAccountTransaction(transferMoneyDto);
		transactionDao.create(accountTransaction[0]);
		transactionDao.create(accountTransaction[1]);
	}
}

//ALTER TABLE account_transaction
//ALTER COLUMN transaction_type TYPE VARCHAR();