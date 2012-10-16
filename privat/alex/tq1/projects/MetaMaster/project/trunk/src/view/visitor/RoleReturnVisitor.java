
package view.visitor;

import view.*;

public interface RoleReturnVisitor<R> {
    
    public R handleCustomer(CustomerView customer) throws ModelException;
    public R handleSupplier(SupplierView supplier) throws ModelException;
    
}
