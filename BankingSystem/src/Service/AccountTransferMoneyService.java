package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Controller.OTPController;
import Converter.AccountTransactionMapper;
import Converter.CustomerMapper;
import DTO.TransferMoneyDTO;
import Dao.AccountDaoImpl;
import Dao.AccountTransactionDaoImpl;
import Dao.TransactionDaoImpl;
import Exception.InsufficientAmountException;
import Exception.NotConfirmedException;
import Exception.TransactionFailedException;
import Model.Account;
import Model.AccountTransaction;
import Model.Customer;
import Model.Transaction;

public class AccountTransferMoneyService extends TransferMoneyService {
	
	private TransferMoneyDTO transferMoneyDto;
	private AccountTransactionDaoImpl accountTransactionDao;
	private TransactionDaoImpl transactionDao;
	private AccountDaoImpl accountDao;
	private Transaction transaction;
	
	public AccountTransferMoneyService(TransferMoneyDTO transferMoneyDto,Transaction transaction)throws InsufficientAmountException, SQLException, TransactionFailedException {
		this.transaction = transaction;
		this.transferMoneyDto = transferMoneyDto;
		this.accountTransactionDao = new AccountTransactionDaoImpl();
		transactionDao = new TransactionDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.transferProcess();
	}
	
	@Override
	public void processTransfer(Connection connection,Transaction transaction ) throws InsufficientAmountException, SQLException, NotConfirmedException {
		
		AccountTransaction[] accountTransaction = AccountTransactionMapper.toAccountTransaction(transferMoneyDto);
		transaction = new Transaction();
		transaction.setCreatedBy(transferMoneyDto.getEmployee());
		transaction.setUpdatedBy(transferMoneyDto.getEmployee());
		
		
		Customer customer = accountTransaction[0].getAccount().getCustomer();
		OTPController otpController = new OTPController(CustomerMapper.toCustomerDTO(customer),transaction);
		otpController.sentOTP();

		calculateWithdrawlAmount(accountTransaction[0]);
		calculateDepositAmount(accountTransaction[1]);
			
		transaction = transactionDao.createTransactionWithIdReturn(transaction,connection);
			
		accountTransaction[0].setTransaction(transaction);
		accountTransaction[1].setTransaction(transaction);
			
		accountTransactionDao.create(accountTransaction[0],connection);
		accountTransactionDao.create(accountTransaction[1],connection);

		
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

	@Override
	public void transferProcess() throws InsufficientAmountException, SQLException, TransactionFailedException {
		
		TransactionManager.executeTransaction((connection) -> {
			        processTransfer(connection,transaction);
			    });
		
	}
}
