
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
