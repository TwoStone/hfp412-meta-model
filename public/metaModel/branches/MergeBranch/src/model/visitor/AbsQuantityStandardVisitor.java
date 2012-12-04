
package model.visitor;

import persistence.*;

public abstract class AbsQuantityStandardVisitor implements AbsQuantityVisitor {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.standardHandling(compoundQuantity);
    }
    protected abstract void standardHandling(PersistentAbsQuantity absQuantity) throws PersistenceException;
}
