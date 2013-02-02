
package model.visitor;

import persistence.*;

public abstract class MAbstractSumTypeStandardVisitor implements MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.standardHandling(mDisjunctiveNF);
    }
    protected abstract void standardHandling(PersistentMAbstractSumType mAbstractSumType) throws PersistenceException;
}
