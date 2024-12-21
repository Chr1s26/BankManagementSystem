package Policy;

import Model.Customer;
import Model.Employee;

public class CustomerPolicy extends BasePolicy<Customer> {

	@Override
	public boolean canCreate(Employee currentUser, Customer resource) {
		return currentUser.isAdmin() || currentUser.isEditor();
	}

	@Override
	public boolean canRead(Employee currentUser, Customer resource) {
		return super.canRead(currentUser, resource);
	}

	@Override
	public boolean canUpdate(Employee currentUser, Customer resource) {
		return super.canUpdate(currentUser, resource);
	}

	@Override
	public boolean canDelete(Employee currentUser, Customer resource) {
		return super.canDelete(currentUser, resource);
	}

}
