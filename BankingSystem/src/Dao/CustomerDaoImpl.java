package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;

public class CustomerDaoImpl extends AbstractDao<Customer> {

	@Override
	public String getTableName() {
		return "customers";
	}

	@Override
	public Customer converToObject(ResultSet resultset) {
		Customer customer = null;
		try {
			int id = resultset.getInt("id");
			String firstName = resultset.getString("first_name");
			String lastName = resultset.getString("last_name");
			String email = resultset.getString("email");
			String phoneNumber = resultset.getString("phone_number");
			String address = resultset.getString("address");
			Date dateOfBirth = resultset.getDate("date_of_birth");
			
			customer = new Customer(id,firstName,lastName,email,phoneNumber,address,dateOfBirth);
		}catch(SQLException e){
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return customer;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (first_name,last_name,email,phone_number,address,date_of_birth) values (?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set first_name = ? , last_name = ?, email = ? , phone_number = ?, address = ?, date_of_birth = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Customer object) {
		try {
			preparedStatement.setString(1,object.getfirstName());
			preparedStatement.setString(2, object.getlastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhoneNumber());
			preparedStatement.setString(5, object.getAddress());
			preparedStatement.setDate(6, object.getdateOfBirth());
			
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Customer object) {
		try {
			preparedStatement.setString(1,object.getfirstName());
			preparedStatement.setString(2, object.getlastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhoneNumber());
			preparedStatement.setString(5, object.getAddress());
			preparedStatement.setDate(6, object.getdateOfBirth());
			preparedStatement.setInt(7, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

}