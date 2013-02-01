
package model.visitor;
import model.UserException;
import persistence.*;

public interface MTypeExceptionVisitor<E extends UserException> extends MComplexTypeExceptionVisitor<E>{
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException, E;
    
}
