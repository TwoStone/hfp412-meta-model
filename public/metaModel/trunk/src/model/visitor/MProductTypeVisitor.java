
package model.visitor;

import persistence.*;

public interface MProductTypeVisitor {
    
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException;
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    
}
