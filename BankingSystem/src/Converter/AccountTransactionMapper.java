package Converter;

import DTO.TransferMoneyDTO;
import Model.AccountTransaction;
import Model.AccountTransactionType;

public class AccountTransactionMapper {
	
	public static AccountTransaction[] toAccountTransaction(TransferMoneyDTO transferMoneyDto) {
		
		AccountTransaction[] accountTransaction = new AccountTransaction[2];
		accountTransaction[0] = new AccountTransaction();
		accountTransaction[0].setTransactionType(AccountTransactionType.COMPLETED);
		accountTransaction[0].setAmount(transferMoneyDto.getAmount());
		accountTransaction[0].setDescription(transferMoneyDto.getDescription());
		accountTransaction[0].setAccount(transferMoneyDto.getSourceAccountNum());
		
		accountTransaction[1] = new AccountTransaction();
		accountTransaction[1].setTransactionType(AccountTransactionType.COMPLETED);
		accountTransaction[1].setAmount(transferMoneyDto.getAmount());
		accountTransaction[1].setDescription(transferMoneyDto.getDescription());
		accountTransaction[1].setAccount(transferMoneyDto.getTargetAccountNum());
		return accountTransaction;
		
	}
}
