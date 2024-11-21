package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Dao.LoanDaoImpl;
import Model.Loan;
import View.LoanListingPage;

public class LoanListingController extends BaseController {
	private LoanListingPage view;
	private LoanDaoImpl loanDao;

	public LoanListingController() {
		super(new LoanListingPage());
		this.loanDao = new LoanDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (LoanListingPage) this.getView();
		
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getLoanData(),columns);
		
		this.view.getCreateButton().addActionListener(e -> handleCreateButton());
		this.view.getUpdateButton().addActionListener(e -> handleUpdateButton());
		this.view.getDeleteButton().addActionListener(e -> handleDeleteButton());
	}

	private void handleDeleteButton() {
		 int selectedRowIndex = getSelectedRow();

		 if (selectedRowIndex == -1) {
			 JOptionPane.showMessageDialog(this.view, "Please select a Loan to delete.");
			 return;
		 }

		 int LoanId = getLoanIdFromSelectedRow(selectedRowIndex);

		 if (confirmDeletion(LoanId)) {
			 deleteLoanAndRefresh(LoanId);
		 }
	}

	private void handleUpdateButton() {
		new LoanUpdateController(this,this.getLoanIdFromSelectedRow(getSelectedRow()));
	}

	private void handleCreateButton() {
		new LoanCreateController(this);
	}
	
	public String[][] getLoanData(){
		List<Loan> Loans = loanDao.getAll();
		String[][] LoanArray = new String[Loans.size()][this.view.getColumns().length];
		int rowCount = 0;
		for(Loan Loan : Loans) {
			LoanArray[rowCount][0] = Loan.getId()+""; 
			LoanArray[rowCount][1] = Loan.getloanAmount()+"";
			LoanArray[rowCount][2] = Loan.getinterestRate()+"";
			LoanArray[rowCount][3] = Loan.getloanStartDate()+"";
			LoanArray[rowCount][4] = Loan.getloanEndDate()+"";
			LoanArray[rowCount][5] = Loan.getCustomer().getfirstName();
			LoanArray[rowCount][6] = Loan.getloanType()+"";
			rowCount++;
		}
		return LoanArray;
	}
	

	private int getSelectedRow() {
			return this.view.getDataTableTemplate().getSelectedRow();
		}
	

	private int getLoanIdFromSelectedRow(int rowIndex) {
			return Integer.parseInt(getLoanData()[rowIndex][0]);
		}
	

	private boolean confirmDeletion(int LoanId) {
			int response = JOptionPane.showConfirmDialog(
					this.view,
					"Are you sure you want to delete Loan with ID " + LoanId + "?",
					"Confirm Deletion",
					JOptionPane.YES_NO_OPTION
		 );
			return response == JOptionPane.YES_OPTION;
		}
		
	private void deleteLoanAndRefresh(int LoanId) {
			 loanDao.delete(LoanId);
			 this.refreshTableData();
			}
	
	public void refreshTableData() {
		this.view.refreshDataTable(getLoanData());
	}

}
