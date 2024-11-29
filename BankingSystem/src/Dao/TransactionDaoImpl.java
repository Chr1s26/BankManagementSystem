package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Account;
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
			Timestamp createdAt = resultset.getTimestamp("createdat");
			Timestamp updatedAt = resultset.getTimestamp("updatedat");
			int createdBy = resultset.getInt("createdby");
			int updatedBy = resultset.getInt("updatedby");
			
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
		
		return "insert into "+this.getTableName()+" (createdby,updatedby) values(?,?)";
		
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set  updatedby = ? where id = ?";
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
	public Transaction createTransactionWithIdReturn(Transaction transaction) {
		try {
			String query = "INSERT INTO transactions (createdby, updatedby) VALUES (?, ?) RETURNING id";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transaction.getCreatedBy().getId());
			preparedStatement.setInt(2, transaction.getUpdatedBy().getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
	            transaction.setId(resultSet.getInt("id"));
	        }
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}finally{
			this.connectionFactory.closeConnection();
		}
	    return transaction;
	}
	

	
}