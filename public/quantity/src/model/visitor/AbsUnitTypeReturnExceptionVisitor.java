
package model.visitor;

import persistence.*;

public interface AbsUnitTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException, E;
    public R handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException, E;
    public R handleUnitType(PersistentUnitType unitType) throws PersistenceException, E;
    
}
