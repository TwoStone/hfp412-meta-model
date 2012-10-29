
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbsUnitTypeExceptionVisitor<E extends UserException> {
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException, E;
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException, E;
    
}
