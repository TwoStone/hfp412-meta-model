
package model.visitor;

import persistence.*;

public interface AbsQuantityVisitor {
    
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException;
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException;
    
}
