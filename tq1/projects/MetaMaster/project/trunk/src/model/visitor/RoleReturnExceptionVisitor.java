
package model.visitor;

import persistence.*;

public interface RoleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCustomer(PersistentCustomer customer) throws PersistenceException, E;
    public R handleSupplier(PersistentSupplier supplier) throws PersistenceException, E;
    
}
