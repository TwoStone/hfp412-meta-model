
package model.visitor;

import persistence.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException;
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
