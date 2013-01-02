
package model.visitor;

import persistence.*;

public abstract class MComplexTypeStandardVisitor implements MComplexTypeVisitor {
    
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
    protected abstract void standardHandling(PersistentMComplexType mComplexType) throws PersistenceException;
}
