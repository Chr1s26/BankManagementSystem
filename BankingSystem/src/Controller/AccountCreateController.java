package Controller;

import DTO.AccountDTO;
import Service.AccountCreateService;
import View.AccountCreateForm;

public class AccountCreateController extends BaseController {
	
	private AccountCreateForm view ;
	private AccountCreateService createService;
	private AccountListingController parentController;
	
	public AccountCreateController(AccountListingController parentController) {
		super(new AccountCreateForm());
		this.parentController = parentController;
		this.authenticate();
	}
	
	public void handleEmployeeRegisteration() {
		AccountDTO AccountDTO = new AccountDTO();
		AccountDTO.setAccountNumber(this.view.getNumberField().getText());
		AccountDTO.setAccountType(this.view.getAccountType());
		AccountDTO.setBalance(Double.parseDouble(this.view.getBalanceField().getText()));
		AccountDTO.setBranch(this.view.getBranch());
		AccountDTO.setCustomer(this.view.getCustomer());
		AccountDTO.setPassword(this.view.getPasswordField());
		AccountDTO.setConfirmedPassword(this.view.getConfirmpasswordField());
		try {
			this.createService.call(AccountDTO);
			this.parentController.refreshTableData();
			this.view.dispose();
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initController() {
		this.view = (AccountCreateForm) this.getView();
		this.view.getCreateButton().addActionListener(e -> handleEmployeeRegisteration());
		this.createService = new AccountCreateService();
	}
}
