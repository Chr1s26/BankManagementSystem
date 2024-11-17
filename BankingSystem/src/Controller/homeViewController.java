package Controller;

import View.HomeView;

public class homeViewController extends BaseController {
	
	private HomeView view;
	
	public homeViewController() {
		super(new HomeView());
		this.authenticate();
		this.initController();
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
		this.view.getCardTransactionListing().addActionListener(e -> addActionOnCardTransaction());
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