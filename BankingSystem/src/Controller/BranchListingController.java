package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import Dao.BranchDaoImpl;
import Model.Branch;
import View.BranchListingPage;


public class BranchListingController extends BaseController {

	private BranchListingPage view;
	private BranchDaoImpl branchDao;

	public BranchListingController() {
		super(new BranchListingPage());
		this.branchDao = new BranchDaoImpl();
		this.authenticate();
	}

	@Override
	public void initController() {
		this.view = (BranchListingPage) this.getView();
		String[] columns = this.view.getColumns();
		this.view.createDataTable(getBranchData(), columns);
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateButtonAction());
		this.view.getUpdateButton().addActionListener(e -> handleBranchUpdateButtonAction());
		this.view.getDeleteButton().addActionListener(e -> handleBranchDeleteButtonAction());
	}

	private void handleBranchDeleteButtonAction() {
		int selectedRowIndex = getSelectedRow();

		if (selectedRowIndex == -1) {
			JOptionPane.showMessageDialog(this.view, "Please select a branch to delete.");
			return;
		}

		int branchId = getbranchIdFromSelectedRow(selectedRowIndex);

		if (confirmDeletion(branchId)) {
			deletebranchAndRefresh(branchId);
		}
	}

	private void handleBranchUpdateButtonAction() {
		int branchId = getbranchIdFromSelectedRow(getSelectedRow());
		if(branchId == -1) {
			JOptionPane.showMessageDialog(this.view, "Please select a branch to update");
		}
		new BranchUpdateController(this,branchId);
	}

	private void handleBranchCreateButtonAction() {
		new BranchCreateController(this);
	}

	public String[][] getBranchData() {
		List<Branch> branches = branchDao.getAll();
		String[][] BranchArray = new String[branches.size()][this.view.getColumns().length];
		int rowCount = 0;
		for (Branch Branch : branches) {
			BranchArray[rowCount][0] = Branch.getId() + "";
			BranchArray[rowCount][1] = Branch.getName();
			BranchArray[rowCount][2] = Branch.getAddress();
			BranchArray[rowCount][3] = Branch.getPhoneNumber();
			rowCount++;
		}
		return BranchArray;
	}

	private int getSelectedRow() {
		return this.view.getDataTableTemplate().getSelectedRow();
	}

	private int getbranchIdFromSelectedRow(int rowIndex) {
		return Integer.parseInt(getBranchData()[rowIndex][0]);
	}

	private boolean confirmDeletion(int branchId) {
		int response = JOptionPane.showConfirmDialog(this.view,
				"Are you sure you want to delete branch with ID " + branchId + "?", "Confirm Deletion",
				JOptionPane.YES_NO_OPTION);
		return response == JOptionPane.YES_OPTION;
	}

	private void deletebranchAndRefresh(int branchId) {
		branchDao.delete(branchId);
		this.refreshTableData();
	}

	public void refreshTableData() {
		this.view.refreshDataTable(getBranchData());
	}

}
