
package model.visitor;

import persistence.*;

public interface MTypeVisitor extends MComplexTypeVisitor{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}
