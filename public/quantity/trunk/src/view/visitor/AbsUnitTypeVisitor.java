
package view.visitor;

import view.*;

public interface AbsUnitTypeVisitor {
    
    public void handleTypeReference(TypeReferenceView typeReference) throws ModelException;
    public void handleCompoundUnitType(CompoundUnitTypeView compoundUnitType) throws ModelException;
    public void handleUnitType(UnitTypeView unitType) throws ModelException;
    
}
