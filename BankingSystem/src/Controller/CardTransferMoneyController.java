package Controller;

import java.sql.SQLException;

import DTO.CardTransferMoneyDTO;
import Exception.InsufficientAmountException;
import Exception.TransactionFailedException;
import Model.Card;
import Model.CurrencyType;
import Model.Employee;
import Model.Transaction;
import Service.AuthenticationService;
import Service.CardTransferMoneyService;
import View.CardTransferMoneyWindow;

public class CardTransferMoneyController extends TransferMoneyController {
	
	private CardTransferMoneyWindow view;
	private CardTransferMoneyService creationService;
	
	public CardTransferMoneyController() {
		super(new CardTransferMoneyWindow());
	}

	@Override
	public void buttonAction() {
		this.view = (CardTransferMoneyWindow)this.getView();
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
		CardTransferMoneyDTO transferMoneyDto = null;
		Transaction transaction = new Transaction();
		
		try {
			Card sourceCardNumber = this.view.getSourceCard();
			Card targetCardNumber = this.view.getTargetCard();
			double amount = Double.parseDouble(this.view.getAmountField().getText());
			String description = this.view.getDescField().getText();
			CurrencyType currency = this.view.getCurrencyType();
			Employee employee = this.currentUser;
			transferMoneyDto = new CardTransferMoneyDTO(sourceCardNumber,targetCardNumber,amount,description,currency,employee);
		
			AuthenticationService.otpAuthenticate(transaction);
			this.view.showSuccessMessage("Money transfer successfully!!");
			this.view.dispose();
        
		}catch (Exception e) {

	        this.view.showErrorMessage("Transfer failed: " + e.getMessage());
	        if (transferMoneyDto != null) {
	            this.creationService = new CardTransferMoneyService(transferMoneyDto, transaction);
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
