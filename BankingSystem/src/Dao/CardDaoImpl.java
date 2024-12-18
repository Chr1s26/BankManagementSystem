package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Account;
import Model.Card;
import Model.CardType;
import Model.Customer;

public class CardDaoImpl extends AbstractDao<Card>{
	
	private CustomerDaoImpl customerDaoImpl;
	private AccountDaoImpl accountDaoImpl;
	
	public CardDaoImpl() {
		customerDaoImpl = new CustomerDaoImpl();
		accountDaoImpl = new AccountDaoImpl();
	}

	@Override
	public String getTableName() {
		return "cards";
	}

	@Override
	public Card converToObject(ResultSet resultset) {
		Card card = null;
		try {
			int id = resultset.getInt("id");
			String cardNumber = resultset.getString("card_number");
			int cardType = resultset.getInt("card_type");
			Date expireDate = resultset.getDate("expire_date");
			int securityCode = resultset.getInt("security_code");
			int customerId = resultset.getInt("customer_id");
			int account_id = resultset.getInt("account_id");
			Customer customer = customerDaoImpl.getById(customerId);
			Account account = accountDaoImpl.getById(account_id);
			
			
			card = new Card(id,cardNumber,CardType.fromValue(cardType),expireDate,securityCode,customer,account);
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return card;
	}
	
	public String changeToString(int cardType) {
		if(cardType == 1) {
			return "Debit Cards";
		}else if (cardType == 2) {
			return "Credit Cards";
		}else if(cardType == 3) {
			return "Prepaid Cards";
		}else if (cardType == 4) {
			return "ATM Cards";
		}else {
			return "null";
		}
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (card_number,card_type,expire_date,security_code,customer_id,account_id) values (?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set card_number = ?, card_type = ? , expire_date = ?, security_code = ?, customer_id = ?, account_id = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Card object) {
		try {
			preparedStatement.setString(1, object.getCardNumber());
			preparedStatement.setInt(2, object.getCardType().getValue());
			preparedStatement.setDate(3, object.getExpireDate());
			preparedStatement.setInt(4, object.getSecurityCode());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setInt(6, object.getAccount().getId());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Card object) {
		try {
			preparedStatement.setString(1, object.getCardNumber());
			preparedStatement.setInt(2, object.getCardType().getValue());
			preparedStatement.setDate(3, object.getExpireDate());
			preparedStatement.setInt(4, object.getSecurityCode());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setInt(6, object.getAccount().getId());
			preparedStatement.setInt(7, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}
	
}
