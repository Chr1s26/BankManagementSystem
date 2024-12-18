package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.OTPController;
import Converter.AccountMapper;
import DTO.AccountDTO;
import Dao.AccountDaoImpl;
import Exception.IncorrectPasswordException;
import Model.Account;

public class AccountCreateService {
	
	private AccountDTO accountDTO;
	private AccountDaoImpl accountDao;

	public AccountCreateService() {
		this.accountDao = new AccountDaoImpl();
	}	
	 
	public void call(AccountDTO AccountDTO) throws Exception {
		this.accountDTO = AccountDTO;
		this.validatePassword();
		OTPController otp = new OTPController(AccountDTO);
		otp.sentOTP();
		this.creationProcess();
		
	}

	private void creationProcess() throws SQLException {
		Account account = AccountMapper.toAccount(this.accountDTO);
		accountDao.create(account);
	}
	
	private void validatePassword() throws IncorrectPasswordException {
		if(!this.accountDTO.getPassword().equals(this.accountDTO.getConfirmedPassword())) {
			throw new IncorrectPasswordException("Password is not equal please check again !!");
		}
	}

}
