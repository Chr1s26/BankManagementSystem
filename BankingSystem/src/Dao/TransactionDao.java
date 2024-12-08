package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Customer;
import Model.Transaction;

public abstract class TransactionDao extends AbstractDao<Transaction>{
	
	public abstract Transaction createTransactionWithIdReturn(Transaction transaction, Connection connection) throws Exception;
	public abstract void setConfirmedAt(Transaction transaction);
	

}
