
package model.visitor;

import persistence.*;

public abstract class MAbstractSumTypeDirectVisitor implements MAbstractSumTypeVisitor {
    
    public abstract void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    
    public abstract void handleMNonEmptySumType(PersistentMNonEmptySumType mNonEmptySumType) throws PersistenceException;
    
    public void handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException{
        this.handleMNonEmptySumType(mDisjuncitveNF);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMNonEmptySumType(mSumType);
    }
    
}
