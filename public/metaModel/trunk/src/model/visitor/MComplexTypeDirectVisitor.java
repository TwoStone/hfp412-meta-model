
package model.visitor;

import persistence.*;

public abstract class MComplexTypeDirectVisitor implements MComplexTypeVisitor {
    
    public abstract void handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException{
        this.handleMProductType(mEmptyProduct);
    }
    public abstract void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
    public void handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException{
        this.handleMSumType(mEmptySum);
    }
    
}
