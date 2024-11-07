package Dao;

import Model.Branch;

public abstract class BranchDao extends AbstractDao<Branch> {
	
	public abstract Branch findByName(String name);
}
