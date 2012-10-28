
package model.visitor;

import persistence.*;

public abstract class AbsUnitStandardVisitor implements AbsUnitVisitor {
    
    public void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException{
        this.standardHandling(compoundUnit);
    }
    public void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException{
        this.standardHandling(unitReference);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    protected abstract void standardHandling(PersistentAbsUnit absUnit) throws PersistenceException;
}
