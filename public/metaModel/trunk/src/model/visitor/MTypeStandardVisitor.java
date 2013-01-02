
package model.visitor;

import persistence.*;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException{
        this.standardHandling(mEmptySum);
    }
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MType mType) throws PersistenceException;
}
