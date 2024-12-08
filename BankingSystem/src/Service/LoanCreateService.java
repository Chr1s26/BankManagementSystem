package Service;

import java.sql.SQLException;

import Converter.LoanMapper;
import DTO.LoanDTO;
import Dao.LoanDaoImpl;
import Model.Loan;

public class LoanCreateService {
	
	private LoanDTO LoanDTO;
	private LoanDaoImpl LoanDao;

	
	public LoanCreateService() {
		this.LoanDao = new LoanDaoImpl();
	}	
	 
	public void call(LoanDTO LoanDTO) throws Exception {
		this.LoanDTO = LoanDTO;
		this.creationProcess();
	}

	private void creationProcess() throws SQLException {
		Loan Loan = LoanMapper.toLoan(this.LoanDTO);
		LoanDao.create(Loan);
	}
}
