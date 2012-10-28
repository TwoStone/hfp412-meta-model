
package model.visitor;

import persistence.*;

public interface AbsUnitReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleUnit(PersistentUnit unit) throws PersistenceException, E;
    public R handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException, E;
    public R handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException, E;
    
}
