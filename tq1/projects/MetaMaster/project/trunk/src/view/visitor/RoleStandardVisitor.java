
package view.visitor;

import view.*;

public abstract class RoleStandardVisitor implements RoleVisitor {
    
    public void handleCustomer(CustomerView customer) throws ModelException{
        this.standardHandling(customer);
    }
    public void handleSupplier(SupplierView supplier) throws ModelException{
        this.standardHandling(supplier);
    }
    protected abstract void standardHandling(RoleView role) throws ModelException;
}
