
package model.visitor;

import persistence.*;

public interface AbsUnitReturnVisitor<R> {
    
    public R handleUnit(PersistentUnit unit) throws PersistenceException;
    public R handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    
}
