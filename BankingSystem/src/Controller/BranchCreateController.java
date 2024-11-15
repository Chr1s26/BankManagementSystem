package Controller;

import DTO.BranchDTO;
import DTO.EmployeeDTO;
import Service.BranchCreateService;
import View.BranchCreateForm;

public class BranchCreateController extends BaseController {
	
	private BranchCreateForm view;
	private BranchCreateService createService;
	
	public BranchCreateController() {
		super(new BranchCreateForm());
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (BranchCreateForm)this.getView();
		this.view.getCreateButton().addActionListener(e -> handleBranchCreateAction());
		this.view.setVisible(true);
	}
	
	private void handleBranchCreateAction() {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setName(this.view.getNameField().getText());
		branchDTO.setAddress(this.view.getAddressField().getText());
		branchDTO.setPhoneNumber(this.view.getPhoneField().getText());
		try {
			this.createService.call(branchDTO);
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
	
}
