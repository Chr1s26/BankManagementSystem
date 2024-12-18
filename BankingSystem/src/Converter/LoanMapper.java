package Converter;

import DTO.LoanDTO;
import Dao.LoanDaoImpl;
import Model.Loan;

public class LoanMapper {
	
	public static LoanDaoImpl loanDao = new LoanDaoImpl();
	
	public static Loan toLoan(LoanDTO loanDto) {
		
		Loan loan = new Loan();
		loan.setloanAmount(loanDto.getLoanAmount());
		loan.setinterestRate(loanDto.getInterestRate());
		loan.setloanStartDate(loanDto.getLoanStartDate());
		loan.setloanEndDate(loanDto.getLoanEndDate());
		loan.setCustomer(loanDto.getCustomer());
		loan.setloanType(loanDto.getLoanType());
		loan.setId(loanDto.getId());
		return loan;
	}
}
