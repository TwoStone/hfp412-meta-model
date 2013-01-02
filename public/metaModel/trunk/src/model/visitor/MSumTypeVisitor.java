
package model.visitor;

import persistence.*;

public interface MSumTypeVisitor {
    
    public void handleMEmptySum(PersistentMEmptySum mEmptySum) throws PersistenceException;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}
