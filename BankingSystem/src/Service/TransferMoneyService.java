package Service;

import Converter.AccountTransactionMapper;
import DTO.TransferMoneyDTO;
import Dao.AccountDaoImpl;
import Dao.AccountTransactionDaoImpl;
import Exception.InsufficientAmountException;
import Model.Account;
import Model.AccountTransaction;

public class TransferMoneyService {
	
	private TransferMoneyDTO transferMoneyDto;
	private AccountTransactionDaoImpl transactionDao;
	private AccountDaoImpl accountDao;

	
	public TransferMoneyService(TransferMoneyDTO transferMoneyDto) throws InsufficientAmountException {
		this.transferMoneyDto = transferMoneyDto;
		this.transactionDao = new AccountTransactionDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.transferProcess();
	}
	
	public void transferProcess() throws InsufficientAmountException {
		AccountTransaction[] accountTransaction = AccountTransactionMapper.toAccountTransaction(transferMoneyDto);
		calculateWithdrawlAmount(accountTransaction[0]);
		calculateDepositAmount(accountTransaction[1]);
		transactionDao.create(accountTransaction[0]);
		transactionDao.create(accountTransaction[1]);
	}
	
	public void calculateWithdrawlAmount(AccountTransaction accountTransaction) throws InsufficientAmountException {
		Account account = accountTransaction.getAccount();
		double amount =account.getBalance() - accountTransaction.getAmount();
		if(amount < 0) {
			throw new InsufficientAmountException("Insufficient Amount");
		}else {
			account.setBalance(amount);
			accountDao.update(account);
		}
 	}
	
	public void calculateDepositAmount(AccountTransaction accountTransaction) throws InsufficientAmountException {
		Account account = accountTransaction.getAccount();
		double amount =account.getBalance() + accountTransaction.getAmount();
		account.setBalance(amount);
		accountDao.update(account);
 	}
}

//ALTER TABLE account_transaction
//ALTER COLUMN transaction_type TYPE VARCHAR();
