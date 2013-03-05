
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MTypeVisitor extends MComplexTypeVisitor{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}
