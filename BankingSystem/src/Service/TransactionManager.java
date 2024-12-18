package Service;

import java.sql.Connection;
import java.sql.SQLException;

import Database.PgSqlConnectionFactory;
import Exception.TransactionFailedException;

public class TransactionManager {
	
	public static void executeTransaction(TransactionOperation operation) throws SQLException, TransactionFailedException {
		Connection connection = null;
		try{
			connection = new PgSqlConnectionFactory().createConnection();
			try {
				connection.setAutoCommit(false);
				operation.execute(connection);
				connection.commit();
				}
			catch(Exception e) {
				connection.rollback();
				throw new TransactionFailedException("Transaction failed.Roll back."+e.getMessage());
			}
		}catch(Exception e) {
			throw new TransactionFailedException("Database connection failed"+e.getMessage());
		}finally {
			connection.close();
		}
	}
	
}
