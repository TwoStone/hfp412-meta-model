
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentCompUnit;
import persistence.PersistentUnit;

public abstract class AbsUnitStandardVisitor implements AbsUnitVisitor {
    
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.standardHandling(compUnit);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    protected abstract void standardHandling(PersistentAbsUnit absUnit) throws PersistenceException;
}
