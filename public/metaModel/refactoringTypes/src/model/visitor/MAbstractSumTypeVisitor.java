
package model.visitor;

import persistence.*;

public interface MAbstractSumTypeVisitor extends MNonEmptySumTypeVisitor{
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException;
    
}
