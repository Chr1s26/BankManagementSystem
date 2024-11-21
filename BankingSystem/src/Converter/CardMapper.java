package Converter;

import DTO.CardDTO;
import Dao.CardDaoImpl;
import Model.Card;

public class CardMapper {
	
	public static CardDaoImpl CardDao = new CardDaoImpl();
	
	public static Card toCard(CardDTO cardDto) {
		Card card = new Card();
		card.setCardNumber(cardDto.getCardNumber());
		card.setCardType(cardDto.getCardType());
		card.setExpireDate(cardDto.getExpireDate());
		card.setSecurityCode(cardDto.getSecurityCode());
		card.setCustomer(cardDto.getCustomer());
		card.setAccount(cardDto.getAccount());
		card.setId(cardDto.getId());
		
		return card;
	}

}
