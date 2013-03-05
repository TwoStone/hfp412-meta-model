
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentQuantity;

public abstract class AbsQuantityStandardVisitor implements AbsQuantityVisitor {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.standardHandling(compoundQuantity);
    }
    protected abstract void standardHandling(PersistentAbsQuantity absQuantity) throws PersistenceException;
}
