package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Branch;

public class BranchDaoImpl extends BranchDao {

	@Override
	public String getTableName() {
		return "branches";
	}

	@Override
	public Branch converToObject(ResultSet resultset) {
		Branch branch = null;
		try {
			int id = resultset.getInt("id");
			String name = resultset.getString("name");
			String address = resultset.getString("address");
			String phoneNumber = resultset.getString("phone_number");
			branch = new Branch(id,name,address,phoneNumber);
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return branch;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (name,address,phone_number) values (?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set name = ?, address = ?, phone_number = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Branch object) {
		try {
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getAddress());
			preparedStatement.setString(3, object.getPhoneNumber());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Branch object) {
		try {
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getAddress());
			preparedStatement.setString(3, object.getPhoneNumber());
			preparedStatement.setInt(4, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public Branch findByName(String name) {
		Branch branch = null;
		try {
			String query = "Select id from "+this.getTableName()+" where name like ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int branchId = resultSet.getInt("id");
				branch = this.getById(branchId);
			}
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
		return branch;
	}

}
