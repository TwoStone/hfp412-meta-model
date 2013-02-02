
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMSumType;

public interface MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
