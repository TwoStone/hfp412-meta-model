
package model.visitor;

import persistence.*;

public abstract class MNonEmptyProductTypeStandardVisitor implements MNonEmptyProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.standardHandling(mAtomicTypeProduct);
    }
    protected abstract void standardHandling(PersistentMNonEmptyProductType mNonEmptyProductType) throws PersistenceException;
}
