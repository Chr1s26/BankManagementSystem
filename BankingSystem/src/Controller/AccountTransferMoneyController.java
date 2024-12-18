package Controller;

import java.sql.SQLException;

import DTO.TransferMoneyDTO;
import Exception.InsufficientAmountException;
import Exception.TransactionFailedException;
import Model.Account;
import Model.CurrencyType;
import Model.Employee;
import Model.Transaction;
import Service.AccountTransferMoneyService;
import Service.AuthenticationService;
import Service.TransferMoneyService;
import View.TransferMoneyWindow;

public class AccountTransferMoneyController extends TransferMoneyController {
	
	private TransferMoneyWindow view;
	private TransferMoneyService creationService;

	public AccountTransferMoneyController() {
		super(new TransferMoneyWindow());
	}
	
	@Override
	public void buttonAction() {
		
		this.view = (TransferMoneyWindow)this.getView();
		this.view.getTransferButton().addActionListener(e -> {
			try {
				transferBtnAction();
			} catch (InsufficientAmountException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (TransactionFailedException e1) {
				e1.printStackTrace();
			}
		});
	}

	@Override
	public void transferBtnAction() throws InsufficientAmountException, SQLException, TransactionFailedException {
	    TransferMoneyDTO transferMoneyDto = null; // Declare and initialize to null
	    Transaction transaction = new Transaction();

	    try {
	        Account sourceAccNumber = view.getSourceAccount();
	        Account targetAccNumber = view.getTargetAccount();
	        double amount = Double.parseDouble(this.view.getAmountField().getText());
	        String description = this.view.getDescField().getText();
	        CurrencyType currency = this.view.getCurrencyType();
	        Employee employee = this.currentUser;

	        transferMoneyDto = new TransferMoneyDTO(sourceAccNumber, targetAccNumber, amount, description, currency, employee);

	        AuthenticationService.otpAuthenticate(transaction);
	        this.view.showSuccessMessage("Money transfer successfully!!");
	        this.view.dispose();

	    } catch (Exception e) {

	        this.view.showErrorMessage("Transfer failed: " + e.getMessage());
	        if (transferMoneyDto != null) {
	            this.creationService = new AccountTransferMoneyService(transferMoneyDto, transaction);
	        } else {
	            System.err.println("TransferMoneyDTO is null. Cannot initialize service.");
	        }

	        this.view.dispose();
	    }
	}


	@Override
	public void clearFields() {
		view.getCancelButton().addActionListener(e -> clearFields());
	    this.view.getAmountField().setText("");
	    this.view.getDescField().setText("");
	}

}
