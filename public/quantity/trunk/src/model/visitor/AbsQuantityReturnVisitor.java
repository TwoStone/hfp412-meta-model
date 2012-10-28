
package model.visitor;

import persistence.*;

public interface AbsQuantityReturnVisitor<R> {
    
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public R handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException;
    
}
