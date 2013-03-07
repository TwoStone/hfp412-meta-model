
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnitType;
import persistence.PersistentUnitType;

public abstract class AbsUnitTypeStandardVisitor implements AbsUnitTypeVisitor {
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(PersistentAbsUnitType absUnitType) throws PersistenceException;
}
