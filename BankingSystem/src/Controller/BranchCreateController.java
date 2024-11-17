package Controller;

import DTO.BranchDTO;
import Service.BranchCreateService;
import View.BranchCreateForm;

public class BranchCreateController extends BaseController {
	
	private BranchCreateForm view;
	private BranchCreateService createService;
	private BranchListingController parentController;
	
	public BranchCreateController(BranchListingController parentController) {
		super(new BranchCreateForm());
		this.parentController = parentController;
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (BranchCreateForm)this.getView();
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateAction());
		this.createService = new BranchCreateService();
	}
	
	private void handleBranchCreateAction() {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setName(this.view.getNameField().getText());
		branchDTO.setAddress(this.view.getAddressField().getText());
		branchDTO.setPhoneNumber(this.view.getPhoneField().getText());
		try {
			this.createService.call(branchDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Branch created successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
	
	
	
}
