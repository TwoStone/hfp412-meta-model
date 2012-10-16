
package model.visitor;

import persistence.*;

public interface RoleReturnVisitor<R> {
    
    public R handleCustomer(PersistentCustomer customer) throws PersistenceException;
    public R handleSupplier(PersistentSupplier supplier) throws PersistenceException;
    
}
