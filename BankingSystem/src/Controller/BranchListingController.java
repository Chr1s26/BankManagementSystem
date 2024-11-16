package Controller;

import DTO.BranchDTO;
import View.BranchCreateForm;
import View.BranchListingPage;
import View.BranchUpdateForm;

public class BranchListingController extends BaseController {
	
	private BranchListingPage view;
	private BranchDTO branchDTO;
	
	public BranchListingController() {
		super(new BranchListingPage());
		this.authenticate();
	}
	

	@Override
	public void initController() {
		this.view =(BranchListingPage) this.getView();
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateButtonAction());
		this.view.getUpdateButton().addActionListener(e -> handleBranchUpdateButtonAction());
		this.view.getDeleteButton().addActionListener(e -> handleBranchDeleteButtonAction());
	}



	private void handleBranchDeleteButtonAction() {
		
	}


	private void handleBranchUpdateButtonAction() {
		new BranchUpdateController();
	}


	private void handleBranchCreateButtonAction() {
		new BranchCreateController();
	}

}
