package Service;

import Converter.CardMapper;
import DTO.CardDTO;
import Dao.CardDaoImpl;
import Model.Card;

public class CardUpdateService {
	
	private CardDTO CardDTO;
	private CardDaoImpl CardDao;

	
	public CardUpdateService() {
		this.CardDao = new CardDaoImpl();
	}	
	 
	public void call(CardDTO CardDTO) throws Exception {
		this.CardDTO = CardDTO;
		this.creationProcess();
	}

	private void creationProcess() {
		Card Card = CardMapper.toCard(this.CardDTO);
		CardDao.update(Card);
	}
}
