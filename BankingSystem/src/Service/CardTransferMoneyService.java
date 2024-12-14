package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Controller.OTPController;
import Converter.CardTransactionMapper;
import Converter.CustomerMapper;
import DTO.CardTransferMoneyDTO;
import Dao.AccountDaoImpl;
import Dao.CardTransactionDaoImpl;
import Dao.TransactionDaoImpl;
import Exception.InsufficientAmountException;
import Exception.NotConfirmedException;
import Exception.TransactionFailedException;
import Model.Account;
import Model.CardTransaction;
import Model.Customer;
import Model.Transaction;

public class CardTransferMoneyService extends TransferMoneyService {
	
	private CardTransferMoneyDTO cardTransferMoneyDto;
	private CardTransactionDaoImpl cardTransactionDao;
	private TransactionDaoImpl transactionDao;
	private AccountDaoImpl accountDao;
	private Transaction transaction;
	
	public CardTransferMoneyService(CardTransferMoneyDTO cardTransferMoneyDto,Transaction transaction)throws InsufficientAmountException, SQLException, TransactionFailedException {
		this.transaction = transaction;
		this.cardTransferMoneyDto = cardTransferMoneyDto;
		this.cardTransactionDao = new CardTransactionDaoImpl();
		transactionDao = new TransactionDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.transferProcess();
	}
	
	@Override
	public void processTransfer(Connection connection,Transaction transaction ) throws InsufficientAmountException, SQLException, NotConfirmedException {
		
		CardTransaction[] cardTransaction = CardTransactionMapper.toCardTransaction(cardTransferMoneyDto);
		transaction = new Transaction();
		transaction.setCreatedBy(cardTransferMoneyDto.getEmployee());
		transaction.setUpdatedBy(cardTransferMoneyDto.getEmployee());
		
		
		Customer customer = cardTransaction[0].getAccount().getCustomer();
		OTPController otpController = new OTPController(CustomerMapper.toCustomerDTO(customer),transaction);
		otpController.sentOTP();

		calculateWithdrawlAmount(cardTransaction[0]);
		calculateDepositAmount(cardTransaction[1]);
			
		transaction = transactionDao.createTransactionWithIdReturn(transaction,connection);
			
		cardTransaction[0].setTransaction(transaction);
		cardTransaction[1].setTransaction(transaction);
			
		cardTransactionDao.create(cardTransaction[0],connection);
		cardTransactionDao.create(cardTransaction[1],connection);

		
	}
	
	public void calculateWithdrawlAmount(CardTransaction cardTransaction) throws InsufficientAmountException {
		Account account = cardTransaction.getAccount();
		double amount =account.getBalance() - cardTransaction.getAmount();
		if(amount < 0) {
			throw new InsufficientAmountException("Insufficient Amount");
		}else {
			account.setBalance(amount);
			accountDao.update(account);
		}
 	}
	
	public void calculateDepositAmount(CardTransaction cardTransaction) throws InsufficientAmountException {
		Account account = cardTransaction.getAccount();
		double amount =account.getBalance() + cardTransaction.getAmount();
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
