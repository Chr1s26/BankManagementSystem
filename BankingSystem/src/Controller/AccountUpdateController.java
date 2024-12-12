package Controller;

import DTO.AccountDTO;
import Dao.AccountDaoImpl;
import Model.Account;
import Service.AccountUpdateService;
import View.AccountUpdateForm;

public class AccountUpdateController extends BaseController {
	
	private AccountUpdateForm view ;
	private AccountUpdateService createService;
	private AccountListingController parentController;
	private Account account;
	private AccountDaoImpl accountDao;
	
	public AccountUpdateController(AccountListingController parentController,int id) {
		super(new AccountUpdateForm());
		this.parentController = parentController;
		this.accountDao = new AccountDaoImpl();
		this.account = accountDao.getById(id);
		this.authenticate();
	}
	
	
	public void handleAccountRegisteration() {
		AccountDTO AccountDTO = new AccountDTO();
		AccountDTO.setAccountNumber(this.view.getNumberField().getText());
		AccountDTO.setAccountType(this.view.getAccountType());
		AccountDTO.setBalance(Double.parseDouble(this.view.getBalanceField().getText()));
		AccountDTO.setBranch(this.view.getBranch());
		AccountDTO.setCustomer(this.view.getCustomer());
		AccountDTO.setId(account.getId());
		AccountDTO.setPassword(this.view.getPasswordField());
		AccountDTO.setConfirmedPassword(this.view.getConfirmpasswordField());;
		try {
			this.createService.call(AccountDTO);
			this.parentController.refreshTableData();
			this.view.dispose();
		}
		catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}	
	
	public void handleAllTransaction() {
		new TransactionListingController(account,0);
	}
	
	public void handleAllDepositTransaction() {
		new TransactionListingController(account,1);
	}
	
	public void handleAllWithDrawlTransaction() {
		new TransactionListingController(account,2);
	}

	@Override
	public void initController() {
		this.view = (AccountUpdateForm) this.getView();
		this.view.getNumberField().setText(account.getaccountNumber());
		this.view.getAccountTypeCombo().setSelectedItem(account.getaccountType());
		this.view.getBalanceField().setText(account.getBalance()+"");
		this.view.getBranchCombo().setSelectedItem(account.getBranch());
		this.view.getCustomerCombo().setSelectedItem(account.getCustomer());
		this.view.getupdateButton().addActionListener(e -> handleAccountRegisteration());
		this.view.getTransactionButton().addActionListener(e -> handleAllTransaction());
		this.view.getIncomeButton().addActionListener(e -> handleAllDepositTransaction());
		this.view.getExpenseButton().addActionListener(e -> handleAllWithDrawlTransaction());
		this.createService = new AccountUpdateService();
	}
}
