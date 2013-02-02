
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMProductType;

public interface MAbstractProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}
