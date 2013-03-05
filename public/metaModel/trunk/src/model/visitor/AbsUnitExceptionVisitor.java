
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentUnit;

public interface AbsUnitExceptionVisitor<E extends UserException> {
    
    public void handleUnit(PersistentUnit unit) throws PersistenceException, E;
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException, E;
    
}
