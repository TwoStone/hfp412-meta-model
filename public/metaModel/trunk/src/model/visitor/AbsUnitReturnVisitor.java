
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentUnit;

public interface AbsUnitReturnVisitor<R> {
    
    public R handleUnit(PersistentUnit unit) throws PersistenceException;
    public R handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    
}
