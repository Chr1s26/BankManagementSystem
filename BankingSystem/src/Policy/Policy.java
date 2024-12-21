package Policy;

import Model.Employee;

public interface Policy<T> {
	
	boolean canCreate(Employee currentUser,T resource);
	boolean canRead(Employee currentUser,T resource);
	boolean canUpdate(Employee currentUser,T resource);
	boolean canDelete(Employee currentUser,T resource);
}
