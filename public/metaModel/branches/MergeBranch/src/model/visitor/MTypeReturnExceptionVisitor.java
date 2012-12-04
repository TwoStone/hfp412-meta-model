
package model.visitor;
import model.UserException;
import persistence.*;

public interface MTypeReturnExceptionVisitor<R, E extends UserException> extends MComplexTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
