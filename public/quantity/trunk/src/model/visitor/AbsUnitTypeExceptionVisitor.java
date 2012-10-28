
package model.visitor;

import persistence.*;

public interface AbsUnitTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException, E;
    public void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException, E;
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException, E;
    
}
