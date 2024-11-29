package Dao;

import Model.Transaction;

public abstract class TransactionDao extends AbstractDao<Transaction>{
	
	public abstract Transaction createTransactionWithIdReturn(Transaction transaction);
}
