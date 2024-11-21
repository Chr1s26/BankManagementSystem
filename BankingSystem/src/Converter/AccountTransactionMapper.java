package Converter;

import DTO.TransferMoneyDTO;
import Model.AccountTransaction;

public class AccountTransactionMapper {
	
	public static AccountTransaction[] toAccountTransaction(TransferMoneyDTO transferMoneyDto) {
		AccountTransaction[] accountTransaction = new AccountTransaction[2];
		accountTransaction[0].setTransactionType("Withdrawl");
		accountTransaction[0].setAmount(transferMoneyDto.getAmount());
		accountTransaction[0].setDescription(transferMoneyDto.getDescription());
		accountTransaction[0].setAccount(transferMoneyDto.getSourceAccountNum());
		accountTransaction[1].setTransactionType("Deposit");
		accountTransaction[1].setAmount(transferMoneyDto.getAmount());
		accountTransaction[1].setDescription(transferMoneyDto.getDescription());
		accountTransaction[1].setAccount(transferMoneyDto.getTargetAccountNum());
		return accountTransaction;
	}
}
