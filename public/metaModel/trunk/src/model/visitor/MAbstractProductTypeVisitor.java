
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeVisitor {
    
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException;
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
    
}
