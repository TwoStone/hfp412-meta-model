
package model.visitor;

import persistence.*;

public abstract class MTypeDirectVisitor implements MTypeVisitor {
    
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
    public abstract void handleMComplexType(PersistentMComplexType mComplexType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMComplexType(mProductType);
    }
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.handleMComplexType(mEmptySumType);
    }
    public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException{
        this.handleMComplexType(mAbstractProductType);
    }
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException{
        this.handleMComplexType(mEmptyProduct);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMComplexType(mSumType);
    }
    
}
