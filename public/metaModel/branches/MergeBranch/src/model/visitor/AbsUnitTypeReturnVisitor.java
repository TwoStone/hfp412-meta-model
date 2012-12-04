
package model.visitor;

import persistence.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    public R handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    
}
