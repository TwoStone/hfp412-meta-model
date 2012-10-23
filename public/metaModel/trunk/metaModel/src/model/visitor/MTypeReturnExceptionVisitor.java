
package model.visitor;

import persistence.*;

public interface MTypeReturnExceptionVisitor<R, E extends model.UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
