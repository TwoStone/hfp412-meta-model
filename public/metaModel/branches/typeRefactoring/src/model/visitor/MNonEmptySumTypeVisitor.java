
package model.visitor;

import persistence.*;

public interface MNonEmptySumTypeVisitor {
    
    public void handleMDisjuncitveNF(PersistentMDisjuncitveNF mDisjuncitveNF) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
