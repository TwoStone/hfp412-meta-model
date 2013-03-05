
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;

public interface AbsUnitTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException, E;
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException, E;
    
}
