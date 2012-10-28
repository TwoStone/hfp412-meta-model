
package model.visitor;

import persistence.*;

public abstract class AbsUnitTypeStandardVisitor implements AbsUnitTypeVisitor {
    
    public void handleTypeReference(PersistentTypeReference typeReference) throws PersistenceException{
        this.standardHandling(typeReference);
    }
    public void handleCompoundUnitType(PersistentCompoundUnitType compoundUnitType) throws PersistenceException{
        this.standardHandling(compoundUnitType);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    protected abstract void standardHandling(PersistentAbsUnitType absUnitType) throws PersistenceException;
}
