package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Account;
import Model.Branch;
import Model.Customer;

public class AccountDaoImpl extends AbstractDao<Account>{
	
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
			
			String accountTypeString = accountType + "";
			account = new Account(id,accountNumber,accountTypeString,balance,createdAt,branch,customer);
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}
		return account;
	}

	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (account_number,account_type,balance,branch_id,customer_id) values (?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set account_number = ?, account_type = ?, balance = ?, branch_id = ?, customer_id = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+" where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Account object) {
		try {
			preparedStatement.setString(1, object.getaccountNumber());
			preparedStatement.setInt(2, Integer.parseInt(object.getaccountType()));
			preparedStatement.setFloat(3, (float)object.getBalance());
			preparedStatement.setInt(4, object.getBranch().getId());
			preparedStatement.setInt(5, object.getCustomer().getId());
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}
		
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Account object) {
		try {
			preparedStatement.setString(1, object.getaccountNumber());
			preparedStatement.setInt(2, Integer.parseInt(object.getaccountType()));
			preparedStatement.setFloat(3, (float)object.getBalance());
			preparedStatement.setInt(4, object.getBranch().getId());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setInt(6, object.getId());
		}catch(SQLException e){
			System.out.print("SQL exception for : "+e.getMessage());
		}
		
	}

}
