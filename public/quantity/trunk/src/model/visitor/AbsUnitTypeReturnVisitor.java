
package model.visitor;

import persistence.*;

public interface AbsUnitTypeReturnVisitor<R> {
    
    public R handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException;
    public R handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException;
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
