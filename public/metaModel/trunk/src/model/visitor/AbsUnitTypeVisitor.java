
package model.visitor;

import persistence.*;

public interface AbsUnitTypeVisitor {
    
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
