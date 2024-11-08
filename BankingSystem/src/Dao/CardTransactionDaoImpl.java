package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Account;
import Model.Card;
import Model.CardTransaction;

public class CardTransactionDaoImpl extends AbstractDao<CardTransaction>{
	
	private AccountDaoImpl accountDaoImpl;
	private CardDaoImpl cardDaoImpl;
	
	public CardTransactionDaoImpl() {
		accountDaoImpl = new AccountDaoImpl();
		cardDaoImpl = new CardDaoImpl();
	}

	@Override
	public String getTableName() {
		return "card_transaction";
	}

	@Override
	public CardTransaction converToObject(ResultSet resultset) {
		CardTransaction cardTransaction = null;
		try {
			int id = resultset.getInt("id");
			double amount = (double) resultset.getFloat("amount");
			Timestamp transactionDate = resultset.getTimestamp("transaction_date");
			String description = resultset.getString("description");
			int accountid = resultset.getInt("account_id");
			int cardid = resultset.getInt("card_id");
			Account account = accountDaoImpl.getById(accountid);
			Card card = cardDaoImpl.getById(cardid);
			
			cardTransaction = new CardTransaction(id,amount,transactionDate,description,account,card);
 		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return cardTransaction;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (amount,transaction_date,description,account_id,card_id) values (?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set amount = ?, transaction_date = ?, description = ?, account_id = ?, card_id = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, CardTransaction object) {
		try {
			preparedStatement.setFloat(1, (float)object.getAmount());
			preparedStatement.setTimestamp(2,object.getTransactionDate());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getAccount().getId());
			preparedStatement.setInt(5, object.getCard().getId());
		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, CardTransaction object) {
		try {
			preparedStatement.setFloat(1, (float)object.getAmount());
			preparedStatement.setTimestamp(2,object.getTransactionDate());
			preparedStatement.setString(3, object.getDescription());
			preparedStatement.setInt(4, object.getAccount().getId());
			preparedStatement.setInt(5, object.getCard().getId());
			preparedStatement.setInt(5, object.getId());
		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

}
