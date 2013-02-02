
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;

public interface AbsUnitTypeVisitor {
    
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
