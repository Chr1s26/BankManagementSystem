package Controller;

import View.HomeView;

public class homeViewController extends BaseController {
	
	private HomeView view;
	
	public homeViewController() {
		super(new HomeView());
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (HomeView)this.getView();
		this.view.getEmployeeListing().addActionListener(e -> addActionOnEmployee());
		this.view.getBranchListing().addActionListener(e -> addActionOnBranch());
		this.view.getCustomerListing().addActionListener(e -> addActionOnCustomer());
		this.view.getAccountListing().addActionListener(e -> addActionOnAccount());
		this.view.getLoanListing().addActionListener(e-> addActionOnLoan());
		this.view.getCardListing().addActionListener(e -> addActionOnCard());
		this.view.getTransactionListing().addActionListener(e -> addActionOnTransaction());
		this.view.getTransferMoney().addActionListener(e -> addActionOnTransferMoney());
		this.view.getCardTransactionListing().addActionListener(e -> addActionOnCardTransaction());
		this.view.getCardTransferMoney().addActionListener(e -> addActionOnCardTransferMoney());
	}

	private void addActionOnCardTransferMoney() {
		new CardTransferMoneyController();
	}

	private void addActionOnTransferMoney() {
		new AccountTransferMoneyController();
	}

	private void addActionOnCardTransaction() {
		new CardTransactionListingController();
	}

	private void addActionOnTransaction() {
		new AccountTransactionListingController();
	}

	private void addActionOnCard() {
		new CardListingController();
	}

	private void addActionOnLoan() {
		new LoanListingController();
	}

	private void addActionOnAccount() {
		new AccountListingController();
	}

	private void addActionOnCustomer() {
		new CustomerListingController();
	}

	private void addActionOnBranch() {
		new BranchListingController();
	}

	private void addActionOnEmployee() {
		new EmployeeListingController();
	}
	
	
}
