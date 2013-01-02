
package model.visitor;

import persistence.*;

public abstract class MSumTypeStandardVisitor implements MSumTypeVisitor {
    
    public void handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException{
        this.standardHandling(mEmptySum);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(PersistentMSumType mSumType) throws PersistenceException;
}
