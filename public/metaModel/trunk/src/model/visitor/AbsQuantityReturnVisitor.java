
package model.visitor;

import persistence.*;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    
}
