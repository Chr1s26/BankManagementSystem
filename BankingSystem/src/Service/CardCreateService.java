package Service;

import java.sql.SQLException;

import Converter.CardMapper;
import DTO.CardDTO;
import Dao.CardDaoImpl;
import Model.Card;

public class CardCreateService {
	
	private CardDTO CardDTO;
	private CardDaoImpl CardDao;

	
	public CardCreateService() {
		this.CardDao = new CardDaoImpl();
	}	
	 
	public void call(CardDTO CardDTO) throws Exception {
		this.CardDTO = CardDTO;
		this.creationProcess();
	}

	private void creationProcess() throws SQLException {
		Card Card = CardMapper.toCard(this.CardDTO);
		CardDao.create(Card);
	}
}
