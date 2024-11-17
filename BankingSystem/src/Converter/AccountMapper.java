package Converter;

import DTO.AccountDTO;
import Model.Account;

public class AccountMapper {
	
	public static Account toAccount(AccountDTO accountDto) {
		Account account = new Account();
		account.setId(accountDto.getId());
		account.setaccountNumber(accountDto.getAccountNumber());
		account.setaccountType(accountDto.getAccountType());
		account.setBalance(accountDto.getBalance());
		account.setCustomer(account.getCustomer());
		account.setBranch(accountDto.getBranch());
		return account;
	}
}