package Controller;

import java.sql.Date;

import DTO.LoanDTO;
import Service.LoanCreateService;
import Util.DateUtil;
import View.LoanCreateForm;

public class LoanCreateController extends BaseController {
	
	private LoanCreateForm view;
	private LoanCreateService createService;
	private LoanListingController parentController;
	
	public LoanCreateController(LoanListingController parentController) {
		super(new LoanCreateForm());
		this.parentController = parentController;
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (LoanCreateForm)this.getView();
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
			this.view.showSuccessMessage("Loan created successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
}
