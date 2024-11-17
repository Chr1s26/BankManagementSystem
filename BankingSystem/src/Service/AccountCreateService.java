package Service;

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
		this.creationProcess();
	}

	private void creationProcess() {
		Account Account = AccountMapper.toAccount(this.AccountDTO);
		accountDao.create(Account);
	}

}
