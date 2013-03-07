
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MTypeExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
