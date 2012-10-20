
package model.visitor;

import persistence.*;

public interface RoleExceptionVisitor<E extends model.UserException> {
    
    public void handleCustomer(PersistentCustomer customer) throws PersistenceException, E;
    public void handleSupplier(PersistentSupplier supplier) throws PersistenceException, E;
    
}
