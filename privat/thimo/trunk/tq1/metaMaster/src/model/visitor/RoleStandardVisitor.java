
package model.visitor;

import persistence.*;

public abstract class RoleStandardVisitor implements RoleVisitor {
    
    public void handleCustomer(PersistentCustomer customer) throws PersistenceException{
        this.standardHandling(customer);
    }
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException{
        this.standardHandling(supplier);
    }
    protected abstract void standardHandling(PersistentRole role) throws PersistenceException;
}
