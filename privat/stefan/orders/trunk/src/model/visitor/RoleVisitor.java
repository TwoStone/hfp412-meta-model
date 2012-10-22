
package model.visitor;

import persistence.*;

public interface RoleVisitor {
    
    public void handleCustomer(PersistentCustomer customer) throws PersistenceException;
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException;
    
}
