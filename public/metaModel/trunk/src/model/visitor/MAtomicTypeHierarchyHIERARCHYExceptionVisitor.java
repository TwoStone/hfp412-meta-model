
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E extends UserException> {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
