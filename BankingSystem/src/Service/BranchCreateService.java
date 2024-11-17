package Service;


import Converter.BranchMapper;
import DTO.BranchDTO;
import Dao.BranchDaoImpl;
import Model.Branch;

public class BranchCreateService {
	
	private BranchDaoImpl branchDaoImpl;
	private BranchDTO branchDto;
	private BranchDaoImpl branchDao;
	
	public BranchCreateService() {
		branchDaoImpl = new BranchDaoImpl();
		branchDao = new BranchDaoImpl();
	}
	
	public void call(BranchDTO branchDTO) {
		branchDto = branchDTO;
		this.createProcess();
	}
	
	public void createProcess() {
		Branch branch = BranchMapper.toBranch(branchDto);
		branchDao.create(branch);
	}
	
}
