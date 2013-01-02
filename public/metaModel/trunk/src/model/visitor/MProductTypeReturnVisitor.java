
package model.visitor;

import persistence.*;

public interface MProductTypeReturnVisitor<R> {
    
    public R handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    
}
