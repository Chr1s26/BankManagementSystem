package Dao;

import java.util.List;

import DTO.TransactionDTO;
import Model.Account;

public abstract class AccountDao extends AbstractDao<Account> {
	
	public abstract Account findAccountByNum(String num);
	public abstract List<TransactionDTO> getAllTransaction(Account account);
	public abstract List<TransactionDTO> getAllDepositTransaction(Account account);
	public abstract List<TransactionDTO> getAllWithDrawlTransaction(Account account);
	
	
}
