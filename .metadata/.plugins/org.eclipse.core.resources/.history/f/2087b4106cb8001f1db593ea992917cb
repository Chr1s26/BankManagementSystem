package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Converter.AccountMapper;
import DTO.AccountDTO;
import Dao.AccountDaoImpl;
import Model.Account;

public class AccountCreateService {
	
	private AccountDTO AccountDTO;
	private AccountDaoImpl accountDao;

	public AccountCreateService() {
		this.accountDao = new AccountDaoImpl();
	}	
	 
	public void call(AccountDTO AccountDTO) throws Exception {
		this.AccountDTO = AccountDTO;
		Account account = AccountMapper.toAccount(this.AccountDTO);
		this.creationProcess(account);
	}

	private void creationProcess(Account account) throws SQLException {
		accountDao.create(account);
	}

}
