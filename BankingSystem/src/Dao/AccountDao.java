package Dao;

import Model.Account;

public abstract class AccountDao extends AbstractDao<Account> {
	
	public abstract Account findAccountByNum(String num);
}
