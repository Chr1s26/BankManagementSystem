package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Account;
import Model.AccountTransactionType;
import Model.Card;
import Model.CardTransaction;
import Model.CurrencyType;
import Model.StatusType;
import Model.Transaction;

public class CardTransactionDaoImpl extends AbstractDao<CardTransaction>{
	
	private AccountDaoImpl accountDaoImpl;
	private CardDaoImpl cardDaoImpl;
	private TransactionDaoImpl transactionDao;
	
	public CardTransactionDaoImpl() {
		accountDaoImpl = new AccountDaoImpl();
		cardDaoImpl = new CardDaoImpl();
		transactionDao = new TransactionDaoImpl();
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
			int status = resultset.getInt("status");
			int currency = resultset.getInt("currency");
			int transactionId = resultset.getInt("transaction_id");
			int type = resultset.getInt("type");
			Transaction transaction = transactionDao.getById(transactionId);
			Account account = accountDaoImpl.getById(accountid);
			Card card = cardDaoImpl.getById(cardid);
			
			cardTransaction = new CardTransaction(id,amount,transactionDate,description,account,card,StatusType.fromValue(status),CurrencyType.fromValue(currency),transaction,AccountTransactionType.fromValue(type));
 		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return cardTransaction;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (amount,description,account_id,card_id,status,currency,transaction_id,type) values (?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set amount = ?, description = ?, account_id = ?, card_id = ?, status = ?, currency = ?, transaction_id = ?, type = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, CardTransaction object) {
		try {
			preparedStatement.setFloat(1, (float)object.getAmount());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.setInt(3, object.getAccount().getId());
			preparedStatement.setInt(4, object.getCard().getId());
			preparedStatement.setInt(5, object.getStatus().getValue());
			preparedStatement.setInt(6, object.getCurrency().getValue());
			preparedStatement.setInt(7, object.getTransaction().getId());
			preparedStatement.setInt(8, object.getType().getValue());
		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}	
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, CardTransaction object) {
		try {
			preparedStatement.setFloat(1, (float)object.getAmount());
			preparedStatement.setString(2, object.getDescription());
			preparedStatement.setInt(3, object.getAccount().getId());
			preparedStatement.setInt(4, object.getCard().getId());
			preparedStatement.setInt(5, object.getStatus().getValue());
			preparedStatement.setInt(6, object.getCurrency().getValue());
			preparedStatement.setInt(7, object.getTransaction().getId());
			preparedStatement.setInt(8, object.getType().getValue());
			preparedStatement.setInt(9, object.getId());
		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

}
