
package model.visitor;

import persistence.*;

public interface MNonEmptyProductTypeVisitor {
    
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException;
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    
}
