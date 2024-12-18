package Controller;

import java.sql.Date;

import DTO.LoanDTO;
import Dao.LoanDaoImpl;
import Model.Loan;
import Service.LoanCreateService;
import Util.DateUtil;
import View.LoanCreateForm;

public class LoanUpdateController extends BaseController {
	
	private LoanCreateForm view;
	private LoanCreateService createService;
	private LoanListingController parentController;
	private Loan loan;
	private LoanDaoImpl loanDao;
	
	public LoanUpdateController(LoanListingController parentController,int loanId) {
		super(new LoanCreateForm());
		this.parentController = parentController;
		this.loanDao = new LoanDaoImpl();
		this.loan = loanDao.getById(loanId);
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (LoanCreateForm)this.getView();
		this.view.getLoanAmountField().setText(loan.getloanAmount()+"");
		this.view.getInterestRateField().setText(loan.getinterestRate()+"");
		this.view.getCustomerComboBoxField().setSelectedItem(loan.getCustomer());
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateAction());
		this.createService = new LoanCreateService();
	}
	
	private void handleBranchCreateAction() {
		LoanDTO LoanDTO = new LoanDTO();
		LoanDTO.setLoanAmount(Double.parseDouble(this.view.getLoanAmountField().getText()));
		LoanDTO.setInterestRate(Double.parseDouble(this.view.getInterestRateField().getText()));
		LoanDTO.setLoanStartDate((Date) this.view.getLoanStartPanel().getModel().getValue());
		LoanDTO.setLoanEndDate((Date) this.view.getLoanStartPanel().getModel().getValue());
		LoanDTO.setCustomer(this.view.getCustomer());
		LoanDTO.setLoanType(this.view.getLoanType());
		try {
			this.createService.call(LoanDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Loan updated successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
}
