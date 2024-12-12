package Service;

import Controller.OTPController;
import Converter.AccountMapper;
import DTO.AccountDTO;
import Dao.AccountDaoImpl;
import Exception.IncorrectPasswordException;
import Model.Account;

public class AccountUpdateService {
	
	private AccountDTO accountDTO;
	private AccountDaoImpl accountDao;

	public AccountUpdateService() {
		this.accountDao = new AccountDaoImpl();
	}	
	 
	public void call(AccountDTO AccountDTO) throws Exception {
		this.accountDTO = AccountDTO;
		this.validatePassword();
		OTPController otp = new OTPController(accountDTO);
		otp.sentOTP();
		this.creationProcess();
	}

	private void creationProcess() {
		Account Account = AccountMapper.toAccount(this.accountDTO);
		accountDao.update(Account);
	}
	
	private void validatePassword() throws IncorrectPasswordException {
		if(!this.accountDTO.getPassword().equals(this.accountDTO.getConfirmedPassword())) {
			throw new IncorrectPasswordException("Password is not equal please check again !!");
		}
	}
}
