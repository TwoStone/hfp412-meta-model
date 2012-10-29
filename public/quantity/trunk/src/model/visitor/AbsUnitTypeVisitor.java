
package model.visitor;

import persistence.*;

public interface AbsUnitTypeVisitor {
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    
}
