
package model.visitor;

import persistence.*;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public R handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    
}
