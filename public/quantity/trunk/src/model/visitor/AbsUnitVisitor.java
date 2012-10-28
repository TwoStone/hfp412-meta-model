
package model.visitor;

import persistence.*;

public interface AbsUnitVisitor {
    
    public void handleUnit(PersistentUnit unit) throws PersistenceException;
    public void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException;
    public void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException;
    
}
