
package model.visitor;

import persistence.*;

public interface AbsUnitTypeVisitor {
    
    public void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException;
    public void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException;
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException;
    
}
