
package model.visitor;

import persistence.*;

public interface AbsQuantityExceptionVisitor<E extends model.UserException> {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException, E;
    public void handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException, E;
    
}
