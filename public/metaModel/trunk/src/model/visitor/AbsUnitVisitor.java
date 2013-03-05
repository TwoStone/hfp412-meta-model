
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentUnit;

public interface AbsUnitVisitor {
    
    public void handleUnit(PersistentUnit unit) throws PersistenceException;
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    
}
