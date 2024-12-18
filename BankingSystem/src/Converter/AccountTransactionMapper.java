package Converter;

import DTO.TransferMoneyDTO;
import Model.AccountTransaction;
import Model.AccountTransactionType;
import Model.StatusType;

public class AccountTransactionMapper {
	
	public static AccountTransaction[] toAccountTransaction(TransferMoneyDTO transferMoneyDto) {
		
		AccountTransaction[] accountTransaction = new AccountTransaction[2];
		accountTransaction[0] = new AccountTransaction();
		accountTransaction[0].setTransactionType(AccountTransactionType.WITHDRAWL);
		accountTransaction[0].setAmount(transferMoneyDto.getAmount());
		accountTransaction[0].setDescription(transferMoneyDto.getDescription());
		accountTransaction[0].setAccount(transferMoneyDto.getSourceAccountNum());
		accountTransaction[0].setCurrency(transferMoneyDto.getCurrency());
		accountTransaction[0].setStatus(StatusType.COMPLETE);
		
		accountTransaction[1] = new AccountTransaction();
		accountTransaction[1].setTransactionType(AccountTransactionType.DEPOSIT);
		accountTransaction[1].setAmount(transferMoneyDto.getAmount());
		accountTransaction[1].setDescription(transferMoneyDto.getDescription());
		accountTransaction[1].setAccount(transferMoneyDto.getTargetAccountNum());
		accountTransaction[1].setCurrency(transferMoneyDto.getCurrency());
		accountTransaction[1].setStatus(StatusType.COMPLETE);
		return accountTransaction;
		
	}
}
