
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
