
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentQuantity;

public interface AbsQuantityVisitor {
    
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    
}
