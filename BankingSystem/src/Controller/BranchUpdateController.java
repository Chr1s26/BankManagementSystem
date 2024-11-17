package Controller;


import DTO.BranchDTO;
import Dao.BranchDaoImpl;
import Model.Branch;
import Service.branchUpdateService;
import View.BranchUpdateForm;

public class BranchUpdateController extends BaseController{
	
	private BranchUpdateForm view;
	private branchUpdateService updateService;
	private BranchListingController parentController;
	private Branch branch;
	private BranchDaoImpl branchDao;
	
	public BranchUpdateController(BranchListingController parentController,int branchId) {
		super(new BranchUpdateForm());
		this.branchDao = new BranchDaoImpl();
		this.branch = branchDao.getById(branchId);
		this.parentController = parentController;
		this.authenticate();
	}
	
	@Override
	public void initController() {
		this.view = (BranchUpdateForm)this.getView();
		this.view.getNameField().setText(this.branch.getName());
		this.view.getAddressField().setText(this.branch.getAddress());
		this.view.getPhoneField().setText(this.branch.getPhoneNumber());
		this.view.getUpdateButton().addActionListener(e -> handleBranchUpdateAction());
		this.updateService = new branchUpdateService();
	}
	
	private void handleBranchUpdateAction() {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setName(this.view.getNameField().getText());
		branchDTO.setAddress(this.view.getAddressField().getText());
		branchDTO.setPhoneNumber(this.view.getPhoneField().getText());
		branchDTO.setId(this.branch.getId());
		try {
			this.updateService.call(branchDTO);
			this.parentController.refreshTableData();
			this.view.showSuccessMessage("Branch updated successfully");
			this.view.dispose();
		}catch(Exception e) {
			this.view.showErrorMessage(e.getMessage());
		}
	}
	
}
