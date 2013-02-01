
package model.visitor;

import persistence.*;

public abstract class MAbstractProductTypeDirectVisitor implements MAbstractProductTypeVisitor {
    
    public abstract void handleMNonEmptyProductType(PersistentMNonEmptyProductType mNonEmptyProductType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMNonEmptyProductType(mProductType);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.handleMNonEmptyProductType(mAtomicTypeProduct);
    }
    public abstract void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
    
}
