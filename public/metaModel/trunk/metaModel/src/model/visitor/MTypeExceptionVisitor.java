
package model.visitor;

import persistence.*;

public interface MTypeExceptionVisitor<E extends model.UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
