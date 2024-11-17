package Converter;

import DTO.BranchDTO;
import Model.Branch;

public class BranchMapper {
	
	public static Branch toBranch(BranchDTO branchDto) {
		Branch branch = new Branch();
		branch.setId(branchDto.getId());
		branch.setName(branchDto.getName());
		branch.setAddress(branchDto.getAddress());
		branch.setPhoneNumber(branchDto.getPhoneNumber());
		return branch;
	}
}
