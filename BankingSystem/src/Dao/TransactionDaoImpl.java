package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Account;
import Model.Customer;
import Model.Employee;
import Model.Transaction;

public class TransactionDaoImpl extends TransactionDao {
	
	private AccountDaoImpl accountDao;
	private EmployeeDaoImpl employeeDao;
	
	public TransactionDaoImpl() {
		accountDao = new AccountDaoImpl();
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public String getTableName() {
		
		return "transactions";
	}

	@Override
	public Transaction converToObject(ResultSet resultset) {
		Transaction transaction = null;
		try {
			int id = resultset.getInt("id");
			Timestamp createdAt = resultset.getTimestamp("created_at");
			Timestamp updatedAt = resultset.getTimestamp("updated_at");
			int createdBy = resultset.getInt("created_by");
			int updatedBy = resultset.getInt("updated_by");
			
			Employee createdEmployee = employeeDao.getById(createdBy);
			Employee updatedEmployee = employeeDao.getById(updatedBy);
			
			transaction = new Transaction(id,createdEmployee,updatedEmployee,createdAt,updatedAt);
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return transaction;
	}

	@Override
	public String getInsertQuery() {
		
		return "insert into "+this.getTableName()+" (created_by,updated_by) values(?,?)";
		
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set  updated_by = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+ " where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Transaction object) {
		try {
			preparedStatement.setInt(1,object.getCreatedBy().getId());
			preparedStatement.setInt(2, object.getUpdatedBy().getId());
		}catch(SQLException e) {
			System.out.print("SQL exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Transaction object) {
		try {
			preparedStatement.setInt(1, object.getUpdatedBy().getId());
			preparedStatement.setInt(2, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL exception for : "+e.getMessage());
		}
	}

	@Override
	public Transaction createTransactionWithIdReturn(Transaction transaction, Connection connection) throws SQLException {
	
			String query = "INSERT INTO transactions (created_by, updated_by) VALUES (?, ?) RETURNING id";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transaction.getCreatedBy().getId());
			preparedStatement.setInt(2, transaction.getUpdatedBy().getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
	            transaction.setId(resultSet.getInt("id"));
	        }
		
	    return transaction;
	}

	@Override
	public void setConfirmedAt(Transaction transaction) {
		try {
			String query = "Update "+this.getTableName()+" set confirmed_at = ? WHERE id = ?";
			Connection connection = connectionFactory.createConnection() ;
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			prepareStatement.setDate(1,sqlDate);
			prepareStatement.setInt(2, transaction.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
		
	}
	

	
}
