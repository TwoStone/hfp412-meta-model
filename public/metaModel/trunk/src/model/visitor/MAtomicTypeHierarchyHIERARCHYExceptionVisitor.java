
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E extends UserException> {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
