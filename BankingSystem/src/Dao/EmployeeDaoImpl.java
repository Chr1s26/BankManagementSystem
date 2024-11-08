package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Branch;
import Model.Employee;

public class EmployeeDaoImpl extends EmployeeDao{
	
	BranchDaoImpl branchDaoImpl;
	
	public EmployeeDaoImpl() {
		branchDaoImpl = new BranchDaoImpl();
	}

	@Override
	public String getTableName() {
		return "employees";
	}

	@Override
	public Employee converToObject(ResultSet resultset) {
		Employee employee = null;
		try {
			int id = resultset.getInt("id");
			String firstName = resultset.getString("first_name");
			String lastName = resultset.getString("last_name");
			String email = resultset.getString("email");
			String phoneNumber = resultset.getString("phone_number");
			String employeePosition = resultset.getString("employee_position");
			Double salary = (double) resultset.getFloat("salary");
			int branchId = resultset.getInt("branch_id");
			Branch branch = branchDaoImpl.getById(branchId);
			employee = new Employee(id,firstName,lastName,email,phoneNumber,employeePosition,salary,branch);
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		return employee;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (first_name,last_name,email,phone_number,employee_position,salary,branch_id,encrypt_password) values (?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set first_name = ?, last_name = ?, email = ?, phone_number = ?, employee_position = ?, salary = ?, branch_id = ? encrypt_password = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Employee object) {
		try {
			preparedStatement.setString(1, object.getfirstName());
			preparedStatement.setString(2, object.getlastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhoneNumber());
			preparedStatement.setString(5, object.getPosition());
			preparedStatement.setFloat(6, (float)object.getSalary());
			preparedStatement.setInt(7, object.getBranch().getId());
			preparedStatement.setString(8, object.getEncryptPassword());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Employee object) {
		try {
			preparedStatement.setString(1, object.getfirstName());
			preparedStatement.setString(2, object.getlastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhoneNumber());
			preparedStatement.setString(5, object.getPosition());
			preparedStatement.setFloat(6, (float)object.getSalary());
			preparedStatement.setInt(7, object.getBranch().getId());
			preparedStatement.setString(8, object.getEncryptPassword());
			preparedStatement.setInt(9, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		
	}

	@Override
	public Employee findByName(String name) {
		Employee employee = null;
		try {
			String query = "Select id from "+this.getTableName()+" where first_name like ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int id = resultSet.getInt("id");
				employee = this.getById(id);
			}
		}catch(SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
		return employee;
	}

}
