
package model.visitor;

import persistence.*;

public interface AbsUnitExceptionVisitor<E extends model.UserException> {
    
    public void handleUnit(PersistentUnit unit) throws PersistenceException, E;
    public void handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException, E;
    public void handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException, E;
    
}
