
package model.visitor;

import persistence.*;

public interface MNonEmptySumTypeVisitor {
    
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
