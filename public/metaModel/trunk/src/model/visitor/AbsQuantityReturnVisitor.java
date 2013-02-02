
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentQuantity;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    
}
