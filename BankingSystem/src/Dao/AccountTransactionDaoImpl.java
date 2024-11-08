package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Account;
import Model.AccountTransaction;

public class AccountTransactionDaoImpl extends AbstractDao<AccountTransaction>{
	
	private AccountDaoImpl accountDaoImpl;
	
	public AccountTransactionDaoImpl() {
		accountDaoImpl = new AccountDaoImpl();
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
			int accountId = resultset.getInt("account_id");
			Account account = this.accountDaoImpl.getById(accountId);
			
			String transactionType = type +"";
			accountTransaction = new AccountTransaction(id,transactionType,amount,transactionDate,description,account);
		} catch(SQLException e) {
			System.out.print("SQL Exception for : "+ e.getMessage());
		}
		return null;
	}

	@Override
	public String getInsertQuery() {
		return "Insert into "+this.getTableName()+" (transaction_type,amount,transaction_date,description,account_id) values (?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set transaction_type = ? amount = ? transaction_date = ? description = ? account_id = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, AccountTransaction object) {
		try {
			preparedStatement.setInt(1, Integer.parseInt(object.getTransactionType()));
			preparedStatement.setFloat(2, (float)object.getAmount());
			preparedStatement.setTimestamp(3, object.getTransactionDate());
			preparedStatement.setString(4, object.getDescription());
			preparedStatement.setInt(5, object.getAccount().getId());
		} catch(SQLException e) {
			System.out.print("SQL Exception for : "+ e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, AccountTransaction object) {
		try {
			preparedStatement.setInt(1, Integer.parseInt(object.getTransactionType()));
			preparedStatement.setFloat(2, (float)object.getAmount());
			preparedStatement.setTimestamp(3, object.getTransactionDate());
			preparedStatement.setString(4, object.getDescription());
			preparedStatement.setInt(5, object.getAccount().getId());
			preparedStatement.setInt(5, object.getId());
		} catch(SQLException e) {
			System.out.print("SQL Exception for : "+ e.getMessage());
		}
		
	}
	
}
