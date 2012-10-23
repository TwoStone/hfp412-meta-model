
package model.visitor;

import persistence.*;

public interface MTypeReturnVisitor<R> extends MComplexTypeReturnVisitor<R> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}
