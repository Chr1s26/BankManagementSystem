package Controller;

import java.util.List;

import DTO.TransactionDTO;
import Model.Account;

public class CardTransactionController extends TransactionListingController {
	
	private static String[] columns = {"Transaction Id","Transaction Type","CreatedAt","To Card Number","Note"};

	public CardTransactionController(Account account,int type) {
		super(account,type,columns);
	}

	@Override
	public List<TransactionDTO> getTransaction(int type) {
		// TODO Auto-generated method stub
		return null;
	}
}
