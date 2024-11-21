package Controller;

import java.sql.Date;

import DTO.CardDTO;
import Dao.CardDaoImpl;
import Model.Card;
import Service.CardUpdateService;
import View.CardUpdateForm;

public class CardUpdateController extends BaseController {
	
	private CardUpdateForm view;
	private CardUpdateService updateService;
	private CardListingController parentController;
	private CardDaoImpl cardDao;
	private Card card;
	
	public CardUpdateController(CardListingController parentController,int id) {
		super(new CardUpdateForm());
		this.cardDao = new CardDaoImpl();
		card = this.cardDao.getById(id);
		this.parentController = parentController;
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (CardUpdateForm)this.getView();
		this.view.getCardNumberField().setText(card.getCardNumber());
		this.view.getSecurityField().setText(card.getSecurityCode()+"");
		this.view.getupdateButton().addActionListener(e -> handleBranchCreateAction());
		this.updateService = new CardUpdateService();
	}
	
	private void handleBranchCreateAction() {
		CardDTO CardDTO = new CardDTO();
		CardDTO.setId(card.getId());
		CardDTO.setCardNumber(this.view.getCardNumberField().getText());
		CardDTO.setCardType(this.view.getCardType());
		CardDTO.setExpireDate((Date)this.view.getExpirePanel().getModel().getValue());
		CardDTO.setSecurityCode(Integer.parseInt(this.view.getSecurityField().getText()));
		CardDTO.setCustomer(this.view.getCustomer());
		CardDTO.setAccount(this.view.getAccount());
		try {
			this.updateService.call(CardDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Loan updated successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
}
