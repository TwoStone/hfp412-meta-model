
package model.visitor;

import persistence.*;

public abstract class MNonEmptySumTypeStandardVisitor implements MNonEmptySumTypeVisitor {
    
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.standardHandling(mDisjunctiveNF);
    }
    protected abstract void standardHandling(PersistentMNonEmptySumType mNonEmptySumType) throws PersistenceException;
}
