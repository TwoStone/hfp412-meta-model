
package model.visitor;

import persistence.*;

public interface AbsQuantityVisitor {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    
}
