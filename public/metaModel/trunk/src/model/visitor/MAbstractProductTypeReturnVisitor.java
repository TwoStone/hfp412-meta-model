
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMProductType;

public interface MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}
