
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}
