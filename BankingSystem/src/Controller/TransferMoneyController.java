package Controller;

import javax.swing.JOptionPane;

import DTO.TransferMoneyDTO;
import Dao.EmployeeDaoImpl;
import Exception.InsufficientAmountException;
import Model.Account;
import Model.CurrencyType;
import Model.Employee;
import Service.TransferMoneyService;
import View.TransferMoneyWindow;

public class TransferMoneyController extends BaseController {
	
	private TransferMoneyWindow view;
	private TransferMoneyService creationService;
	private EmployeeDaoImpl employeeDao;
	
	public TransferMoneyController() {
		super(new TransferMoneyWindow());
		this.authenticate();
		this.employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public void initController() {
		this.view = (TransferMoneyWindow)this.getView();
		this.view.getTransferButton().addActionListener(e -> transferBtnAction());
		this.view.getCancelButton().addActionListener(e -> clearFields());
	}

	private void transferBtnAction() {
		Account sourceAccNumber = this.view.getSourceAccount();
		Account targetAccNumber = this.view.getTargetAccount();
		double amount = Double.parseDouble(this.view.getAmountField().getText());
		String description = this.view.getDescField().getText();
		CurrencyType currency = this.view.getCurrencyType();
		Employee employee = this.currentUser;
		TransferMoneyDTO transferMoneyDto = new TransferMoneyDTO(sourceAccNumber,targetAccNumber,amount,description,currency,employee);
		try {
			this.creationService = new TransferMoneyService(transferMoneyDto);
			this.view.showSuccessMessage("Money transfer Successfully!!");
			this.view.dispose();
		}catch(InsufficientAmountException e) {
			this.view.showErrorMessage(e.getMessage());
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
    private void clearFields() {
        this.view.getAmountField().setText("");
        this.view.getDescField().setText("");
    }
}
