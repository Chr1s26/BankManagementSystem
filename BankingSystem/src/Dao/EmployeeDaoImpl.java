package Dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.IncorrectEmailException;
import Exception.IncorrectPasswordException;
import Exception.IncorrectUserNameException;
import Exception.InvalidTokenException;
import Model.Branch;
import Model.Employee;
import Util.PasswordUtil;
import Util.TokenUtil;

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
			String password = resultset.getString("encrypt_password");
			java.sql.Date confirmAt = resultset.getDate("confirmed_at");
			employee = new Employee(id,firstName,lastName,email,phoneNumber,employeePosition,salary,branch,password);
			employee.setConfirmedAt(confirmAt);
			
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
		return "update "+this.getTableName()+" set first_name = ?, last_name = ?, email = ?, phone_number = ?, employee_position = ?, salary = ?, branch_id = ? ,encrypt_password = ? where id = ?";
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
			System.out.print("SQL Update Exception for : "+e.getMessage());
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

	
	@Override
	public boolean isEmailExists(String email) {
		boolean exists = false;
		try{
			String query = "SELECT id FROM "+this.getTableName()+" WHERE email = ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			exists = resultSet.next();
		}catch (SQLException e) {
	        System.out.print("SQL Exception for isEmailExists: " + e.getMessage());
	    }
		return exists;
	}
	

	@Override
	public boolean isPhoneExists(String phoneNumber) {
		boolean exists = false;
		try {
			String query = "SELECT id FROM "+this.getTableName()+" WHERE phone_number = ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phoneNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			exists = resultSet.next();
		}catch(SQLException e) {
			System.out.print("SQL Exception for isPhoneNumberExists: "+e.getMessage());
		}
		return exists;
	}
	
	
	@Override
	public Employee validateEmployee(String email,String password) throws IncorrectPasswordException, IncorrectEmailException {
		Employee employee = this.getEmployeeByEmployeeEmail(email);
		if(employee != null) {
			String hashedPassword = PasswordUtil.encryptPassword(password);
			String passwordHash = employee.getEncryptPassword();
			Boolean flag = passwordHash != null && passwordHash.equals(hashedPassword);
			if(flag) {
				String logintoken = TokenUtil.generateToken(employee.getEmail());
				employee.setLoginToken(logintoken);
				this.updateLoginToken(employee);
				return employee;
			}else {
				throw new IncorrectPasswordException("Incorrect Password for: "+password);
			}
			
		}else {
			throw new IncorrectEmailException("Incorrect email for: "+email);
		}
	}
	

	@Override
	public void updateLoginToken(Employee employee) {
		try {
			String query = "update "+this.getTableName()+" set login_token = ? where id = ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getLoginToken());
			preparedStatement.setInt(2, employee.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}finally {
			this.connectionFactory.closeConnection();
		}
	}	

	
	@Override
	public void validateLoginToken(Employee employee) throws InvalidTokenException {
		Employee object = null;
		try {
			String query = "SELECT * FROM "+this.getTableName()+" WHERE email = ? AND login_token = ?";
			Connection connection = connectionFactory.createConnection() ;
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, employee.getEmail());
			prepareStatement.setString(2, employee.getLoginToken());
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				object = this.converToObject(resultSet);
				if(object == null) {
					throw new InvalidTokenException("Invalid Token for: "+employee.getLoginToken());
				}
			}
		} catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
	}
	

	@Override
	public Employee getEmployeeByEmployeeEmail(String email) {
		Employee object = null;
		try {
			String query = "SELECT * FROM "+this.getTableName()+" WHERE email = ?";
			Connection connection = connectionFactory.createConnection() ;
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, email);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			if(resultSet.next()) {
				object = this.converToObject(resultSet);
			}
			
		} catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
		return object;
	}
	
	
	@Override
	public void setConfimedAt(Employee employee) {
		try {
			String query = "Update "+this.getTableName()+" set confirmed_at = ? WHERE id = ?";
			Connection connection = connectionFactory.createConnection() ;
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			prepareStatement.setDate(1,sqlDate);
			prepareStatement.setInt(2, employee.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("SQL Exception for : "+e.getMessage());
		}
		finally {
			this.connectionFactory.closeConnection();
		}
	}


}
