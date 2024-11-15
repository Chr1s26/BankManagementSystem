package Service;

import java.util.ArrayList;
import java.util.List;

import Converter.BranchMapper;
import DTO.BranchDTO;
import Dao.BranchDaoImpl;
import Model.Branch;

public class BranchCreateService {
	
	private BranchDaoImpl branchDaoImpl;
	private List<String> errorMessages = new ArrayList<>();
	private BranchDTO branchDto;
	private BranchDaoImpl branchDao;
	
	public BranchCreateService() {
		branchDaoImpl = new BranchDaoImpl();
	}
	
	public void call(BranchDTO branchDTO) {
		errorMessages.clear();
		branchDto = branchDTO;
		this.createProcess();
	}
	
	public void createProcess() {
		Branch branch = BranchMapper.toBranch(branchDto);
		branchDao.create(branch);
	}
	
	public void checkErrorMessage() throws Exception {
		if(!errorMessages.isEmpty()) {
			throw new Exception(errorMessages.toString().concat("\n"));
		}
	}
}
