package Controller;

import java.sql.Date;

import DTO.CardDTO;
import Service.CardCreateService;
import Util.DateUtil;
import View.CardCreateForm;

public class CardCreateController extends BaseController {
	
	private CardCreateForm view;
	private CardCreateService createService;
	private CardListingController parentController;
	
	public CardCreateController(CardListingController parentController) {
		super(new CardCreateForm());
		this.parentController = parentController;
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (CardCreateForm)this.getView();
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateAction());
		this.createService = new CardCreateService();
	}
	
	private void handleBranchCreateAction() {
		CardDTO CardDTO = new CardDTO();
		CardDTO.setCardNumber(this.view.getCardNumberField().getText());
		CardDTO.setCardType(this.view.getCardType());
		CardDTO.setExpireDate((Date)this.view.getExpirePanel().getModel().getValue());
		CardDTO.setSecurityCode(Integer.parseInt(this.view.getSecurityField().getText()));
		CardDTO.setCustomer(this.view.getCustomer());
		CardDTO.setAccount(this.view.getAccount());
		try {
			this.createService.call(CardDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Loan created successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
}
