
package view.visitor;

import view.*;

public interface RoleVisitor {
    
    public void handleCustomer(CustomerView customer) throws ModelException;
    public void handleSupplier(SupplierView supplier) throws ModelException;
    
}
