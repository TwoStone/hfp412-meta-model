
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;

public interface AbsUnitTypeExceptionVisitor<E extends UserException> {
    
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException, E;
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException, E;
    
}
