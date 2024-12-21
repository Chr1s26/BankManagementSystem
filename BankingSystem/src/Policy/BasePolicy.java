package Policy;

import Model.Employee;

public abstract class BasePolicy<T> implements Policy<T> {

	@Override
	public boolean canCreate(Employee currentUser, T resource) {
		return false;
	}

	@Override
	public boolean canRead(Employee currentUser, T resource) {
		return false;
	}

	@Override
	public boolean canUpdate(Employee currentUser, T resource) {
		return false;
	}

	@Override
	public boolean canDelete(Employee currentUser, T resource) {
		return false;
	}
	
}
