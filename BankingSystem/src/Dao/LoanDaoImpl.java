package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;
import Model.Loan;
import Model.LoanType;

public class LoanDaoImpl extends AbstractDao<Loan>{
	
	CustomerDaoImpl customerDaoImpl;
	
	public LoanDaoImpl() {
		customerDaoImpl = new CustomerDaoImpl();
	}
	
	@Override
	public String getTableName() {
		return "loans";
	}

	@Override
	public Loan converToObject(ResultSet resultset) {
		Loan loan = null;
		try {
			int id = resultset.getInt("id");
			int loan_type = resultset.getInt("loan_type");
			double loan_amount =(double) resultset.getFloat("loan_amount");
			double interest_rate = (double) resultset.getFloat("interest_rate");
			Date loan_start = resultset.getDate("loan_start_date");
			Date loan_end = resultset.getDate("loan_end_date");
			int customerId = resultset.getInt("customer_id");
			Customer customer = customerDaoImpl.getById(customerId);
			
			loan = new Loan(id,LoanType.fromValue(loan_type),loan_amount,interest_rate,loan_start,loan_end,customer);
		}catch(SQLException e) {
			System.out.print("SQL exception for : "+e.getMessage());
		}
		return loan;
	}


	@Override
	public String getInsertQuery() {
		return "insert into "+this.getTableName()+" (loan_amount,interest_rate,loan_start_date,loan_end_date,customer_id,loan_type) values(?,?,?,?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update "+this.getTableName()+" set loan_amount = ?, interest_rate = ?, loan_start_date = ?, loan_end_date = ?, customer_id = ?, loan_type = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from "+this.getTableName()+ " where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Loan object) {
		try {
			preparedStatement.setFloat(1,(float) object.getloanAmount());
			preparedStatement.setFloat(2,(float) object.getinterestRate());
			preparedStatement.setDate(3, object.getloanStartDate());
			preparedStatement.setDate(4, object.getloanEndDate());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setInt(6, object.getloanType().getValue());
		}catch(SQLException e) {
			System.out.print("SQL exception for : "+e.getMessage());
		}
	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Loan object) {
		try {
			preparedStatement.setFloat(1,(float) object.getloanAmount());
			preparedStatement.setFloat(2,(float) object.getinterestRate());
			preparedStatement.setDate(3, object.getloanStartDate());
			preparedStatement.setDate(4, object.getloanEndDate());
			preparedStatement.setInt(5, object.getCustomer().getId());
			preparedStatement.setInt(6, object.getloanType().getValue());
			preparedStatement.setInt(7, object.getId());
		}catch(SQLException e) {
			System.out.print("SQL exception for : "+e.getMessage());
		}
		
	}

}
