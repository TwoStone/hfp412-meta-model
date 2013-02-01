
package model.visitor;

import persistence.*;

public interface MNonEmptyProductTypeReturnVisitor<R> {
    
    public R handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    
}
