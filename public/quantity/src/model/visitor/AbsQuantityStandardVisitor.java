
package model.visitor;

import persistence.*;

public abstract class AbsQuantityStandardVisitor implements AbsQuantityVisitor {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleComposedQuantity(PersistentComposedQuantity composedQuantity) throws PersistenceException{
        this.standardHandling(composedQuantity);
    }
    protected abstract void standardHandling(PersistentAbsQuantity absQuantity) throws PersistenceException;
}
