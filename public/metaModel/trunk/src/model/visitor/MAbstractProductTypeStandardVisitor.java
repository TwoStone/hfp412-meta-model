
package model.visitor;

import persistence.*;

public abstract class MAbstractProductTypeStandardVisitor implements MAbstractProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.standardHandling(mEmptyProductType);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.standardHandling(mAtomicTypeProduct);
    }
    protected abstract void standardHandling(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
}
