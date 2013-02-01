
package model.visitor;

import persistence.*;

public abstract class MNonEmptySumTypeStandardVisitor implements MNonEmptySumTypeVisitor {
    
    public void handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException{
        this.standardHandling(mDisjuncitveNF);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(PersistentMNonEmptySumType mNonEmptySumType) throws PersistenceException;
}
