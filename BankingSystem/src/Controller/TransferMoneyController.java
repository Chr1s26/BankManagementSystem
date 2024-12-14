package Controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import Exception.InsufficientAmountException;
import Exception.TransactionFailedException;


public abstract class TransferMoneyController extends BaseController {
	
	public TransferMoneyController(JFrame view) {
		super(view);
		this.authenticate();
	}

	@Override
	public void initController() {
		buttonAction();
	}
	
	public abstract void buttonAction();

	public abstract void transferBtnAction()throws InsufficientAmountException, SQLException, TransactionFailedException ;
	
    public abstract void clearFields();
    

    
    
    


}
