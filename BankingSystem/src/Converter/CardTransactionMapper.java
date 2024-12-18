package Converter;

import DTO.CardTransferMoneyDTO;
import Model.AccountTransactionType;
import Model.CardTransaction;
import Model.StatusType;

public class CardTransactionMapper {
	
	public static CardTransaction[] toCardTransaction(CardTransferMoneyDTO transferMoneyDto) {
		
		CardTransaction[] cardTransaction = new CardTransaction[2];
		cardTransaction[0] = new CardTransaction();
		cardTransaction[0].setType(AccountTransactionType.WITHDRAWL);
		cardTransaction[0].setAmount(transferMoneyDto.getAmount());
		cardTransaction[0].setDescription(transferMoneyDto.getDescription());
		cardTransaction[0].setAccount(transferMoneyDto.getSourceCardNum().getAccount());
		cardTransaction[0].setCurrency(transferMoneyDto.getCurrency());
		cardTransaction[0].setStatus(StatusType.COMPLETE);
		cardTransaction[0].setCard(transferMoneyDto.getSourceCardNum());
		
		cardTransaction[1] = new CardTransaction();
		cardTransaction[1].setType(AccountTransactionType.DEPOSIT);
		cardTransaction[1].setAmount(transferMoneyDto.getAmount());
		cardTransaction[1].setDescription(transferMoneyDto.getDescription());
		cardTransaction[1].setAccount(transferMoneyDto.getTargetCardNum().getAccount());
		cardTransaction[1].setCurrency(transferMoneyDto.getCurrency());
		cardTransaction[1].setStatus(StatusType.COMPLETE);
		cardTransaction[1].setCard(transferMoneyDto.getTargetCardNum());
		return cardTransaction;
		
	}
}
