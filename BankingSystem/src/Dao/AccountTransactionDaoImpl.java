package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DTO.TransactionDTO;
import Model.Account;
import Model.AccountTransaction;
import Model.AccountTransactionType;
import Model.CurrencyType;
import Model.StatusType;
import Model.Transaction;

public class AccountTransactionDaoImpl extends AccountTransactionDao{
	
	private AccountDaoImpl accountDao;
	private TransactionDaoImpl transactionDao;
	
	public AccountTransactionDaoImpl() {
		accountDao = new AccountDaoImpl();
		transactionDao = new TransactionDaoImpl();
	}
	
	@Override
	public String getTableName() {
		return "account_transaction";
	}

	@Override
	public AccountTransaction converToObject(ResultSet resultset) {
		AccountTransaction accountTransaction = null;
		try {
			int id = resultset.getInt("id");
			int type = resultset.getInt("transaction_type");
			double amount = (double) resultset.getFloat("amount");
			Timestamp transactionDate = resultset.getTimestamp("transaction_date");
			String description = resultset.getString("description");
			int status = resultset.getInt("status");
			int currency = resultset.getInt("currency");
			int transactionId = resultset.getInt("transaction_id");
			int accountId = resultset.getInt("account_id");
			
			Account account = accountDao.getById(accountId);
			Transaction transaction = transactionDao.getById(transactionId);
			
			accountTransaction = new AccountTransaction(id,AccountTransactionType.fromValue(type),amount,transactionDate,description,StatusType.fromValue(status),CurrencyType.fromValue(currency),transaction,account);
		} catch(SQLException e) {
			System.out.print("SQL Exception for : "+ e.getMessage());
		}
		return accountTransaction;
	}

	@Override
	public String getInsertQuery() {
		return "Insert into "+this.getTableName()+" (transaction_type,amount,description,status,currency,transaction_id,account_id) values (?,?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set transaction_type = ? amount = ? description = ? status = ? currency = ? transaction_id = ? account_id = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, AccountTransaction object) {
		try {
			System.out.print(object.getTransaction());
			preparedStatement.setInt(1, object.getTransactionType().getValue());
			preparedStatement.setFloat(2, (float)object.getAmount());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getStatus().getValue());
			preparedStatement.setInt(5, object.getCurrency().getValue());
			preparedStatement.setInt(6, object.getTransaction().getId());
			preparedStatement.setInt(7, object.getAccount().getId());
		} catch(SQLException e) {
			System.out.print("SQL Exception for accountTransactionDao : "+ e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, AccountTransaction object) {
		try {
			preparedStatement.setInt(1, object.getTransactionType().getValue());
			preparedStatement.setFloat(2, (float)object.getAmount());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getStatus().getValue());
			preparedStatement.setInt(5, object.getCurrency().getValue());
			preparedStatement.setInt(6, object.getTransaction().getId());
			preparedStatement.setInt(7, object.getAccount().getId());
			preparedStatement.setInt(8, object.getId());
		} catch(SQLException e) {
			System.out.print("SQL Exception for : "+ e.getMessage());
		}
		
	}

	
	
}
