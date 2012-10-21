
package view.visitor;

import view.*;

public interface RoleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCustomer(CustomerView customer) throws ModelException, E;
    public R handleSupplier(SupplierView supplier) throws ModelException, E;
    
}
