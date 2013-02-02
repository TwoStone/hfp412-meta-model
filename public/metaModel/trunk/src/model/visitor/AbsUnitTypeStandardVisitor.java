
package model.visitor;

import persistence.*;

public abstract class AbsUnitTypeStandardVisitor implements AbsUnitTypeVisitor {
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(PersistentAbsUnitType absUnitType) throws PersistenceException;
}
