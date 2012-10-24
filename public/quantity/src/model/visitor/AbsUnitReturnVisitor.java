
package model.visitor;

import persistence.*;

public interface AbsUnitReturnVisitor<R> {
    
    public R handleUnit(PersistentUnit unit) throws PersistenceException;
    public R handleUnitReference(PersistentUnitReference unitReference) throws PersistenceException;
    public R handleCompoundUnit(PersistentCompoundUnit compoundUnit) throws PersistenceException;
    
}
