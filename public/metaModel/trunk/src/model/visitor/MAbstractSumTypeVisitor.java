
package model.visitor;

import persistence.*;

public interface MAbstractSumTypeVisitor {
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
