package Service;

import Converter.AccountMapper;
import DTO.AccountDTO;
import Dao.AccountDaoImpl;
import Model.Account;

public class AccountUpdateService {
	
	private AccountDTO AccountDTO;
	private AccountDaoImpl accountDao;

	public AccountUpdateService() {
		this.accountDao = new AccountDaoImpl();
	}	
	 
	public void call(AccountDTO AccountDTO) throws Exception {
		this.AccountDTO = AccountDTO;
		this.creationProcess();
	}

	private void creationProcess() {
		Account Account = AccountMapper.toAccount(this.AccountDTO);
		accountDao.update(Account);
	}
}
