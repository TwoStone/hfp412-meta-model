
package view.visitor;

import view.*;

public abstract class AbsUnitTypeStandardVisitor implements AbsUnitTypeVisitor {
    
    public void handleTypeReference(TypeReferenceView typeReference) throws ModelException{
        this.standardHandling(typeReference);
    }
    public void handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException{
        this.standardHandling(compoundUnitType);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    protected abstract void standardHandling(AbsUnitTypeView absUnitType) throws ModelException;
}
