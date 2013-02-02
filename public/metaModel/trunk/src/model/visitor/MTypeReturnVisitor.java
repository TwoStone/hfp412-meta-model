
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MTypeReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}
