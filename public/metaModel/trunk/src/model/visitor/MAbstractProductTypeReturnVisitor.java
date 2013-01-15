
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public R handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
    
}
