
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAbstractSumType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMSumType;

public abstract class MAbstractSumTypeStandardVisitor implements MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(PersistentMAbstractSumType mAbstractSumType) throws PersistenceException;
}
