
package view.visitor;

import view.*;

public interface RoleExceptionVisitor<E extends model.UserException> {
    
    public void handleCustomer(CustomerView customer) throws ModelException, E;
    public void handleSupplier(SupplierView supplier) throws ModelException, E;
    
}
