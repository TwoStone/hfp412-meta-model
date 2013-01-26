
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}
