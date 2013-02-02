
package model.visitor;

import persistence.*;

public abstract class MAbstractSumTypeDirectVisitor implements MAbstractSumTypeVisitor {
    
    public abstract void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    
    public abstract void handleMNonEmptySumType(PersistentMNonEmptySumType mNonEmptySumType) throws PersistenceException;
    
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMNonEmptySumType(mSumType);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.handleMNonEmptySumType(mDisjunctiveNF);
    }
    
}
