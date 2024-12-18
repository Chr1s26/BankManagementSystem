package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Controller.OTPController;
import Converter.AccountTransactionMapper;
import Converter.CustomerMapper;
import Converter.EmployeeMapper;
import DTO.TransferMoneyDTO;
import Dao.AccountDaoImpl;
import Dao.AccountTransactionDaoImpl;
import Dao.TransactionDaoImpl;
import Database.PgSqlConnectionFactory;
import Exception.InsufficientAmountException;
import Exception.NotConfirmedException;
import Exception.TransactionFailedException;
import Model.Account;
import Model.AccountTransaction;
import Model.Customer;
import Model.Employee;
import Model.Transaction;

public abstract class TransferMoneyService {

	
	public abstract void transferProcess() throws InsufficientAmountException,SQLException, TransactionFailedException;
	public abstract void processTransfer(Connection connection,Transaction transaction ) throws InsufficientAmountException, SQLException, NotConfirmedException ;

}

