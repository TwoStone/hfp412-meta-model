
package model.visitor;

import persistence.*;

public interface AbsQuantityReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException, E;
    public R handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException, E;
    
}
