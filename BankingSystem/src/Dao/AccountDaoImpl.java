package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.TransactionDTO;
import Model.Account;
import Model.AccountTransactionType;
import Model.AccountType;
import Model.Branch;
import Model.Customer;

public class AccountDaoImpl extends AccountDao{
	
	private BranchDaoImpl branchDaoImpl;
	private CustomerDaoImpl customerDaoImpl;
	
	public AccountDaoImpl() {
		branchDaoImpl = new BranchDaoImpl();
		customerDaoImpl = new CustomerDaoImpl();
	}
	
	@Override
	public String getTableName() {
		return "accounts";
	}

	@Override
	public Account converToObject(ResultSet resultset) {
		Account account = null;
		try {
			int id = resultset.getInt("id");
			String accountNumber = resultset.getString("account_number");
			int accountType = resultset.getInt("account_type");
			double balance = (double)resultset.getFloat("balance"); 
			Date createdAt = resultset.getDate("created_at");
			int branchId = resultset.getInt("branch_id");
			Branch branch = branchDaoImpl.getById(branchId);
			int customerId = resultset.getInt("customer_id");
			Customer customer = customerDaoImpl.getById(customerId);
		
			account = new Account(id,accountNumber,AccountType.fromValue(accountType),balance,createdAt,branch,customer);
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}
		return account;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (account_number,account_type,balance,branch_id,customer_id,password) values (?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set account_number = ?, account_type = ?, balance = ?, branch_id = ?, customer_id = ?, password = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Account object) {
		try {
			preparedStatement.setString(1, object.getaccountNumber());
			preparedStatement.setInt(2, object.getaccountType().getValue());
			preparedStatement.setFloat(3, (float)object.getBalance());
			preparedStatement.setInt(4, object.getBranch().getId());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setString(6, object.getEncryptPassword());
			
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}	
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Account object) {
		try {
			preparedStatement.setString(1, object.getaccountNumber());
			preparedStatement.setInt(2,object.getaccountType().getValue());
			preparedStatement.setFloat(3, (float)object.getBalance());
			preparedStatement.setInt(4, object.getBranch().getId());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setString(6, object.getEncryptPassword());
			preparedStatement.setInt(7, object.getId());
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}
		
	}

	@Override
	public Account findAccountByNum(String num) {
		Account account = null;
		try {
			String query = "Select id from "+this.getTableName()+" where account_number = ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preapredStatement = connection.prepareStatement(query);
			preapredStatement.setString(1,num);
			ResultSet resultset = preapredStatement.executeQuery();
			if(resultset.next()) {
				int id = resultset.getInt("id");
				account = this.getById(id);
			}
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
		return account;
	}
	
	@Override
	public List<TransactionDTO> getAllTransaction(Account account) {
		List<TransactionDTO> objects = new ArrayList<TransactionDTO>();
		try {
			String query = "SELECT t.created_at,at.transaction_type,at.transaction_id,a.account_number,at.amount,at.description\r\n"
					+ "FROM account_transaction at\r\n"
					+ "JOIN \r\n"
					+ "transactions t \r\n"
					+ "ON at.transaction_id = t.id\r\n"
					+ "JOIN \r\n"
					+ "accounts a ON at.account_id = a.id\r\n"
					+ "WHERE \r\n"
					+ "a.id = ?";
			Connection connection = this.connectionFactory.createConnection();
			PreparedStatement preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1,account.getId());
			ResultSet resultset = preparestatement.executeQuery();
			while(resultset.next()) {
				TransactionDTO transactionDTO = new TransactionDTO();
				transactionDTO.setTransactionId(resultset.getInt("transaction_id"));
				int type = resultset.getInt("transaction_type");
				transactionDTO.setType(AccountTransactionType.fromValue(type));
				transactionDTO.setCreatedAt(resultset.getString("created_at"));
				transactionDTO.setNumber(resultset.getString("account_number"));
				transactionDTO.setAmount(resultset.getDouble("amount"));
				transactionDTO.setDescription(resultset.getString("description"));
				objects.add(transactionDTO);
			}
		}catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
			
		}finally {
			this.connectionFactory.closeConnection();
		}
		return objects;
	}

	@Override
	public List<TransactionDTO> getAllDepositTransaction(Account account) {
		List<TransactionDTO> objects = new ArrayList<TransactionDTO>();
		try {
			String query = "SELECT t.created_at,at.transaction_type,at.transaction_id,a.account_number,at.amount,at.description\r\n"
					+ "FROM account_transaction at\r\n"
					+ "JOIN \r\n"
					+ "transactions t \r\n"
					+ "ON at.transaction_id = t.id\r\n"
					+ "JOIN \r\n"
					+ "accounts a ON at.account_id = a.id\r\n"
					+ "WHERE \r\n"
					+ "at.transaction_type = 1 and a.id = ?";
			Connection connection = this.connectionFactory.createConnection();
			PreparedStatement preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1,account.getId());
			ResultSet resultset = preparestatement.executeQuery();
			while(resultset.next()) {
				TransactionDTO transactionDTO = new TransactionDTO();
				transactionDTO.setTransactionId(resultset.getInt("transaction_id"));
				int type = resultset.getInt("transaction_type");
				transactionDTO.setType(AccountTransactionType.fromValue(type));
				transactionDTO.setCreatedAt(resultset.getString("created_at"));
				transactionDTO.setNumber(resultset.getString("account_number"));
				transactionDTO.setAmount(resultset.getDouble("amount"));
				transactionDTO.setDescription(resultset.getString("description"));
				objects.add(transactionDTO);
			}
		}catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
			
		}finally {
			this.connectionFactory.closeConnection();
		}
		return objects;
	}

	@Override
	public List<TransactionDTO> getAllWithDrawlTransaction(Account account) {
		List<TransactionDTO> objects = new ArrayList<TransactionDTO>();
		try {
			String query = "SELECT t.created_at,at.transaction_type,at.transaction_id,a.account_number,at.amount,at.description\r\n"
					+ "FROM account_transaction at\r\n"
					+ "JOIN \r\n"
					+ "transactions t \r\n"
					+ "ON at.transaction_id = t.id\r\n"
					+ "JOIN \r\n"
					+ "accounts a ON at.account_id = a.id\r\n"
					+ "WHERE \r\n"
					+ "at.transaction_type = 2 and a.id = ?";
			Connection connection = this.connectionFactory.createConnection();
			PreparedStatement preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1,account.getId());
			ResultSet resultset = preparestatement.executeQuery();
			while(resultset.next()) {
				TransactionDTO transactionDTO = new TransactionDTO();
				transactionDTO.setTransactionId(resultset.getInt("transaction_id"));
				int type = resultset.getInt("transaction_type");
				transactionDTO.setType(AccountTransactionType.fromValue(type));
				transactionDTO.setCreatedAt(resultset.getString("created_at"));
				transactionDTO.setNumber(resultset.getString("account_number"));
				transactionDTO.setAmount(resultset.getDouble("amount"));
				transactionDTO.setDescription(resultset.getString("description"));
				objects.add(transactionDTO);
			}
		}catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
			
		}finally {
			this.connectionFactory.closeConnection();
		}
		return objects;
	}


}
