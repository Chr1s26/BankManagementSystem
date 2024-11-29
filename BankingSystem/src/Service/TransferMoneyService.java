package Service;

import Converter.AccountTransactionMapper;
import DTO.TransferMoneyDTO;
import Dao.AccountDaoImpl;
import Dao.AccountTransactionDaoImpl;
import Dao.TransactionDaoImpl;
import Exception.InsufficientAmountException;
import Model.Account;
import Model.AccountTransaction;
import Model.Transaction;

public class TransferMoneyService {
	
	private TransferMoneyDTO transferMoneyDto;
	private AccountTransactionDaoImpl accountTransactionDao;
	private TransactionDaoImpl transactionDao;
	private AccountDaoImpl accountDao;
	 
	
	public TransferMoneyService(TransferMoneyDTO transferMoneyDto) throws InsufficientAmountException {
		this.transferMoneyDto = transferMoneyDto;
		this.accountTransactionDao = new AccountTransactionDaoImpl();
		transactionDao = new TransactionDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.transferProcess();
	}
	
	public void transferProcess() throws InsufficientAmountException {
		AccountTransaction[] accountTransaction = AccountTransactionMapper.toAccountTransaction(transferMoneyDto);
		
		Transaction transaction = new Transaction();
		transaction.setCreatedBy(transferMoneyDto.getEmployee());
		transaction.setUpdatedBy(transferMoneyDto.getEmployee());
		
		calculateWithdrawlAmount(accountTransaction[0]);
		calculateDepositAmount(accountTransaction[1]);
		
		transaction = transactionDao.createTransactionWithIdReturn(transaction);
		
		
		accountTransaction[0].setTransaction(transaction);
		accountTransaction[1].setTransaction(transaction);
		
		accountTransactionDao.create(accountTransaction[0]);
		accountTransactionDao.create(accountTransaction[1]);
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
